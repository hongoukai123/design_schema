package com.kai.chap.result;

/**
 * 响应消息
 * @author hongok
 * @since 2018-12-20 16:20:13
 */
public interface ResponseMsg {

    String USER_NOT_EXISt = "用户不存在";
    String USER_OR_PWD_ERROR = "用户名或密码错误";
    String USER_FREEZE = "用户已被冻结";
    String USER_YET_REGISTER = "用户已被注册";
    String TOKEN_INVALID = "无效的token";
    String TOKEN_NULL = "token为空，请重新登录";
    String ID_NOT_NULL = "ID不能为空";

}
