package com.kai.chap.found.build.reality;

/**
 * 导演者类
 * @author hok
 * @since 2019-1-16 09:46:28
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    /**
     * 产品构建方法，负责调用各零件的构建方法
     * @param toAddress
     * @param fromAddress
     */
    public void construct(String toAddress, String fromAddress){
        this.builder.buildTo(toAddress);
        this.builder.buildFrom(fromAddress);
        this.builder.buildSubject();
        this.builder.buildBody();
        this.builder.buildSendDate();
        this.builder.sendMessage();
    }

}
