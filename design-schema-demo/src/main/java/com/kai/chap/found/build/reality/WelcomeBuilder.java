package com.kai.chap.found.build.reality;

/**
 * 欢迎
 * 具体建造者类
 * @author hok
 * @since 2019-1-15 18:08:28
 */
public class WelcomeBuilder extends Builder {

    public WelcomeBuilder(){
        msg = new WelcomeMessage();
    }


    public void buildSubject() {
        msg.setBody("欢迎内容");
    }

    public void buildBody() {
        msg.setSubject("欢迎标题");
    }

}
