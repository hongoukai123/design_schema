package com.kai.chap.controller.user;

import com.kai.chap.ConverUtil;
import com.kai.chap.common.jwt.JwtUtil;
import com.kai.chap.common.note.PassToken;
import com.kai.chap.common.note.UserLoginToken;
import com.kai.chap.dto.LoginDTO;
import com.kai.chap.dto.RegisterDTO;
import com.kai.chap.dto.UserInfoDTO;
import com.kai.chap.po.UserInfo;
import com.kai.chap.result.ResponseCode;
import com.kai.chap.result.ResponseMsg;
import com.kai.chap.result.ResponseResult;
import com.kai.chap.service.user.IUserInfoService;
import com.kai.chap.utils.SaltUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     用户控制器类
 * </p>
 * @author hok
 * @since 2019-1-26 16:36:37
 */
@RestController
@RequestMapping("api/user")
@Api(value = "user", tags = "用户模块接口")
public class UserInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 登录
     * @param loginDTO
     * @since 2019-1-26 16:37:08
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParam(name = "loginDTO", value = "用户登录传输对象LoginDTO", required = true, dataType = "LoginDTO")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDTO loginDTO) {
        Subject subject = SecurityUtils.getSubject();
        String password = SaltUtil.getSaltPassword(loginDTO.getUsername(), loginDTO.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(loginDTO.getUsername(), password);
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            return new ResponseResult(ResponseCode.USER_OR_PWD_ERROR,null, ResponseMsg.USER_OR_PWD_ERROR);
        } catch (LockedAccountException e) {
            return new ResponseResult(ResponseCode.USER_FREEZE,null, ResponseMsg.USER_FREEZE);
        } catch (AuthenticationException e) {
            return new ResponseResult(ResponseCode.USER_NOT_EXISt,null, ResponseMsg.USER_NOT_EXISt);
        } catch (Exception e) {
            return ResponseResult.error();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token", JwtUtil.sign(loginDTO.getUsername(), password));
        return ResponseResult.success(map);
    }

    /**
     * <p>
     *     验证用户名是否存在
     * </p>
     * <p>
     *     此接口需要登录成功后拿到token，访问时带上token才可以正常访问。
     * </p>
     * @param username 用户名
     * @since 2019-1-26 16:37:26
     * @return 响应结果
     */
    @ApiOperation(value = "验证用户名是否存在", notes = "验证用户名是否存在")
    @ApiImplicitParam(name = "username", value = "用户名username", required = true)
    @GetMapping("/verify/{username}")
    @UserLoginToken
    public ResponseResult verifyUsername(@PathVariable("username") String username){
        try {
            UserInfo userInfo = userInfoService.findByName(username);
            if (userInfo != null) {
                return new ResponseResult(false);
            }
        }catch (Exception e){
            return ResponseResult.error();
        }
        return new ResponseResult(true);
    }

    /**
     * <p>
     *     注册
     * </p>
     * @param registerDTO
     * @since 2019-1-26 16:37:37
     * @return 响应结果
     */
    @ApiOperation(value = "注册", notes = "用户注册")
    @ApiImplicitParam(name = "registerDTO", value = "用户传输对象RegisterDTO", required = true, dataType = "RegisterDTO")
    @PostMapping("/register")
    @PassToken
    public ResponseResult register(@RequestBody RegisterDTO registerDTO){
        try{
            UserInfo userInfo = userInfoService.findByName(registerDTO.getUsername());
            if (userInfo != null) {
                return new ResponseResult(ResponseCode.USER_YET_REGISTER, false, ResponseMsg.USER_YET_REGISTER);
            }
            UserInfo user = ConverUtil.convert(UserInfo.class, registerDTO);
            userInfoService.save(user);
        }catch (RuntimeException e){
            return new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID);
        }catch (Exception e){
            return ResponseResult.error();
        }
        return ResponseResult.success(null);
    }

    /**
     * <p>
     *     修改用户信息
     * </p>
     * <p>
     *     此接口需要登录成功后拿到token，访问时带上token才可以正常访问。
     * </p>
     * @param registerDTO 用户传入的对象
     * @since 2019-1-26 16:37:53
     * @return
     */
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParam(name = "registerDTO", value = "用户传输对象RegisterDTO", required = true, dataType = "RegisterDTO")
    @PostMapping("/update")
    @UserLoginToken
    public ResponseResult update(@RequestBody RegisterDTO registerDTO){
        try{
            if(registerDTO.getId().equals("") || registerDTO.getId() == null){
                return new ResponseResult(ResponseCode.ID_NOT_NULL, null, ResponseMsg.ID_NOT_NULL);
            }
            UserInfo userInfo = ConverUtil.convert(UserInfo.class, registerDTO);
            userInfoService.update(userInfo);
        } catch (RuntimeException e){
            return new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID);
        }catch (Exception e){
            return ResponseResult.error();
        }
        return ResponseResult.success(null);
    }

    /**
     * <p>
     *     根据id删除用户信息
     * </p>
     * <p>
     *     此接口需要登录成功后拿到token，访问时带上token才可以正常访问。
     * </p>
     * @param id 用户ID
     * @since 2019-1-26 16:42:00
     * @return
     */
    @ApiOperation(value = "删除用户信息", notes = "根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping("/delete/{id}")
    @UserLoginToken
    public ResponseResult delete(@PathVariable("id") String id){
        try {
            userInfoService.delete(id);
        }catch (RuntimeException e){
            return new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID);
        }catch (Exception e){
            return ResponseResult.error();
        }
        return ResponseResult.success(null);
    }

    /**
     * <p>
     *     获取带分页的用户列表
     * </p>
     * <p>
     *     此接口需要登录成功后拿到token，访问时带上token才可以正常访问。
     * </p>
     * @param userInfoDTO 条件参数
     * @param start 页码
     * @param size 每页数据条数
     * @since 2019-1-26 16:43:28
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取带条件查询分页的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfoDTO", value = "用户传输对象userInfoDTO", required = true, dataType = "UserInfoDTO")
    })
    @PostMapping("/list")
    @UserLoginToken
    public ResponseResult getPageListByObj(@RequestBody UserInfoDTO userInfoDTO){
        Map<String, Object> maps = new HashMap<String, Object>();
        try{
            UserInfo userInfo = ConverUtil.convert(UserInfo.class, userInfoDTO);
            List<UserInfo> userInfoList = userInfoService.getPageListByObj(userInfo);
            List<UserInfoDTO> userInfoDTOS = ConverUtil.convert(UserInfoDTO.class, userInfoList);
            maps.put("userInfoList", userInfoDTOS);
            maps.put("currentSize", userInfoDTOS.size());
            maps.put("countSize", userInfoService.countByObj(userInfo));
        }catch (RuntimeException e){
            return new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID);
        }catch (Exception e){
            return ResponseResult.error();
        }
        return ResponseResult.success(maps);
    }

    /**
     * <p>
     *     未登录shiro会重定向到登录界面，
     *     此处返回未登录状态信息由前端控制跳转页面。
     * </p>
     * @since 2019-1-29 10:37:04
     * @return
     */
    @ApiOperation(value = "未登录状态信息", notes = "获取未登录状态信息由前端控制跳转")
    @GetMapping("/unauth")
    @PassToken
    public ResponseResult unauth(){
        return new ResponseResult(ResponseCode.NO_LOGIN,null, ResponseMsg.NO_LOGIN);
    }

}
