package com.kai.chap.found.prototype.easy;

/**
 * 具体原型角色1
 * @author hok
 * @since 2019-1-16 15:11:17
 */
public class ConcretePrototype1 implements Prototype {

    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype1();
        return prototype;
    }

}
