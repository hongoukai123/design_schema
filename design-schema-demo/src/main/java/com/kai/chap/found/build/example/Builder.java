package com.kai.chap.found.build.example;

/**
 * 抽象建造者类
 * @author hok
 * @since 2019-1-15 15:08:05
 */
public interface Builder {

    /**
     * 建造方法1
     */
    public void buildPart1();

    /**
     * 建造方法2
     */
    public void buildPart2();

    /**
     * 返还结构方法
     * @return
     */
    public Product retrieveResult();

}
