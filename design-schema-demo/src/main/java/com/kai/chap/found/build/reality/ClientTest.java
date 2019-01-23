package com.kai.chap.found.build.reality;

/**
 * 建造模式测试
 * @author hok
 * @since 2019-1-16 09:53:44
 */
public class ClientTest {

    public static void main(String[] args){
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("123456@qq.com", "654321@qq.com");
    }

}
