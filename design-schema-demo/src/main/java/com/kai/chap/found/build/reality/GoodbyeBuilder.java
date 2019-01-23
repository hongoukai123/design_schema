package com.kai.chap.found.build.reality;

/**
 * 欢送
 * 具体建造类
 * @author hok
 * @since 2019-1-15 18:09:52
 */
public class GoodbyeBuilder extends Builder {

    public GoodbyeBuilder(){
        msg = new GoodbyeMessage();
    }

    public void buildSubject() {
        msg.setBody("欢送内容");
    }

    public void buildBody() {
        msg.setSubject("欢送标题");
    }

}
