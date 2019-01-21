package com.kai.chap.common.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kai.chap.JsonUtil;
import com.kai.chap.common.note.PassToken;
import com.kai.chap.common.note.UserLoginToken;
import com.kai.chap.po.UserInfo;
import com.kai.chap.result.ResponseCode;
import com.kai.chap.result.ResponseMsg;
import com.kai.chap.result.ResponseResult;
import com.kai.chap.service.user.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * token拦截器
 * 验证api权限
 * @author hongok
 * @since 2018-12-28 10:52:47
 */
public class VerifyInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyInterceptor.class);

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    LOGGER.error("无token，请重新登录");
                    returnJson(httpServletResponse, ResponseCode.TOKEN_NULL, ResponseMsg.TOKEN_NULL);
                }
                // 获取 token 中的 user id
                String username = JwtUtil.getUsername(token);
                if(username == null){
                    LOGGER.error("token无效！");
                    returnJson(httpServletResponse, ResponseCode.TOKEN_INVALID, ResponseMsg.TOKEN_INVALID);
                }
                UserInfo userInfo = userInfoService.findByName(username);
                if (userInfo == null) {
                    LOGGER.error("token无效！");LOGGER.error("token无效！");
                    returnJson(httpServletResponse, ResponseCode.TOKEN_INVALID, ResponseMsg.TOKEN_INVALID);
                }
                // 验证 token
                if(!JwtUtil.verify(token, username, userInfo.getPassword())){
                    LOGGER.error("token无效！");
                    returnJson(httpServletResponse, ResponseCode.TOKEN_INVALID, ResponseMsg.TOKEN_INVALID);
                }
                return true;
            }
        }
        return true;
    }

    private void returnJson(HttpServletResponse response, Integer code, String msg) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JsonUtil.objChangeJson(new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID)));
        } catch (IOException e) {
            LOGGER.error("response error",e);
            writer.print(JsonUtil.objChangeJson(ResponseResult.error()));
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
