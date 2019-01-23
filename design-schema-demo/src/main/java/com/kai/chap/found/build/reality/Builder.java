package com.kai.chap.found.build.reality;

import java.util.Date;

/**
 * 抽象建造者类
 * @author hok
 * @since 2019-1-15 17:02:46
 */
public abstract class Builder {

    /**
     * 定义产品对象
     */
    protected AutoMessage msg;

    /**
     * 收件人零件的建造方法
     * @param to 收件人地址
     */
    public void buildTo(String to){
        msg.setTo(to);
    }

    /**
     * 发件人零件的建造方法
     * @param from 发件人地址
     */
    public void buildFrom(String from){
        msg.setFrom(from);
    }

    /**
     * 标题零件的建造方法
     */
    public abstract void buildSubject();

    /**
     * 内容零件的建造方法
     */
    public abstract void buildBody();

    /**
     * 发送时间零件的建造方法
     */
    public void buildSendDate(){
        msg.setSendDate(new Date());
    }

    /**
     * 邮件产品完成后，使用此方法发送邮件
     * 此方法相当于产品返还方法
     */
    public void sendMessage(){
        msg.send();
    }

}
