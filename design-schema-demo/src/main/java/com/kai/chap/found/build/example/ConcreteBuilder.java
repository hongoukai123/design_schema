package com.kai.chap.found.build.example;

/**
 * 具体建造者类
 * @author hok
 * @since 2019-1-15 15:12:38
 */
public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    /**
     * 产品零件建造方法1
     */
    public void buildPart1() {
        //构建产品的第一个零件
        product.setPart1("编号：9527");
    }

    /**
     * 产品零件建造方法2
     */
    public void buildPart2() {
        product.setPart2("名称：锤子");
    }

    /**
     * 产品返还方法
     * @return
     */
    public Product retrieveResult() {
        return product;
    }

}
