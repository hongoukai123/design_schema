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

@RestController
@RequestMapping("user")
public class UserInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 登录
     * @param loginDTO
     * @return
     */
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
     * 验证用户名是否存在
     * @param username
     * @return
     */
    @GetMapping("/verify/{username}")
    @UserLoginToken
    public ResponseResult verifyUsername(@PathVariable(name = "username") String username){
        try {
            UserInfo userInfo = userInfoService.findByName(username);
            if (userInfo != null) {
                return new ResponseResult(ResponseCode.USER_YET_REGISTER, false, ResponseMsg.USER_YET_REGISTER);
            }
        }catch (Exception e){
            return ResponseResult.error();
        }
        return new ResponseResult(true);
    }

    /**
     * 注册
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    @UserLoginToken
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

    @PostMapping("list/page/{start}/size/{size}")
    @UserLoginToken
    public ResponseResult getPageListByObj(@RequestBody UserInfoDTO userInfoDTO, @PathVariable("start") Integer start, @PathVariable("size") Integer size){
        try{
            UserInfo userInfo = ConverUtil.convert(UserInfo.class, userInfoDTO);
            List<UserInfo> userInfoList = userInfoService.getPageListByObj(userInfo);
            List<UserInfoDTO> userInfoDTOS = ConverUtil.convert(UserInfoDTO.class, userInfoList);
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("userInfoList", userInfoDTOS);
            maps.put("currentSize", userInfoDTOS.size());
            maps.put("countSize", userInfoService.countByObj(userInfo));
        }catch (RuntimeException e){
            return new ResponseResult(ResponseCode.TOKEN_INVALID, null, ResponseMsg.TOKEN_INVALID);
        }catch (Exception e){
            return ResponseResult.error();
        }
        return ResponseResult.success(null);
    }

}
