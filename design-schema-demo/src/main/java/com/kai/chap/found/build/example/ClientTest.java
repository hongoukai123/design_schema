package com.kai.chap.found.build.example;

/**
 * 测试建造者模式
 * @author hok
 * @since 2019-1-15 15:31:53
 */
public class ClientTest {

    public static void main(String[] args){
        //具体建造者类
        Builder builder = new ConcreteBuilder();
        //导演者
        Director director = new Director(builder);
        director.construct();

        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }

}
