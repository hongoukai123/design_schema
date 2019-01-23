package com.kai.chap.found.prototype.easy;

/**
 * 具体原型角色2
 * @author hok
 * @since 2019-1-16 15:14:31
 */
public class ConcretePrototype2 implements Prototype {

    public Prototype clone() {
        //最简单的克隆,新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }

}
