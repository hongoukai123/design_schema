package com.kai.chap.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 */
public final class SaltUtil {

    public static String getSaltPassword(String username, String password){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(username);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 1024;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSaltPassword("Jack", "123456"));
    }

}
