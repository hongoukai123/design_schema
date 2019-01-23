package com.kai.chap.found.prototype.easy;

/**
 * 客户端角色
 * @author hok
 * @since 2019-1-16 15:16:14
 */
public class Client {

    private Prototype prototype;

    /**
     * 构造方法，传入需要使用的原型接口对象
     * @param prototype
     */
    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public void operation(Prototype example){
        //需要创建原型接口的对象
        Prototype copyPrototype = (Prototype) prototype.clone();
    }

}
