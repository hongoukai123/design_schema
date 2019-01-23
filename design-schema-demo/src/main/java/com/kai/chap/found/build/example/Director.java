package com.kai.chap.found.build.example;

/**
 * 导演者类
 * @author hok
 * @since 2019-1-15 15:18:59
 */
public class Director {

    /**
     * 持有当前所需要的建造器对象
     */
    private Builder builder;

    /**
     * 构造方法，传入建造器对象
     * @param builder
     */
    public Director(Builder builder){
        this.builder = builder;
    }

    /**
     * 产品构造方法，负责调用各个零件建造方法
     */
    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }

}
