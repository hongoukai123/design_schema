package com.kai.chap.result;

/**
 * 响应状态码
 * @author hongok
 * @since 2018-12-20 16:15:49
 */
public interface ResponseCode {

    //用户不存在
    Integer USER_NOT_EXISt = 2002;
    //用户名或密码错误
    Integer USER_OR_PWD_ERROR = 2003;
    //用户已被冻结
    Integer USER_FREEZE = 2004;
    //用户已被注册
    Integer USER_YET_REGISTER = 2005;
    //token为空，请重新登录
    Integer TOKEN_NULL = 2006;
    //token无效
    Integer TOKEN_INVALID = 2007;
    //ID不能为空
    Integer ID_NOT_NULL = 2008;
    //未登录
    Integer NO_LOGIN = 2009;

}
