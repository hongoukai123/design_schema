package com.kai.chap.found.prototype.register;

/**
 * 具体原型角色
 * @author hok
 * @since 2019-1-16 16:47:45
 */
public class ConcretePrototype1 implements Prototype {

    private String name;

    public Prototype clone() {
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        concretePrototype1.setName(name);
        return concretePrototype1;
    }

    public String toString(){
        return "Now in Prototype1, name = " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
