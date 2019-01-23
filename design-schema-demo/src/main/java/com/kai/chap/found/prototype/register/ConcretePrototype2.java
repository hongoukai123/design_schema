package com.kai.chap.found.prototype.register;

/**
 * 具体原型类2
 * @author hok
 * @since 2019-1-16 16:54:16
 */
public class ConcretePrototype2 implements Prototype {

    private String name;

    public Prototype clone() {
        ConcretePrototype2 concretePrototype2 = new ConcretePrototype2();
        concretePrototype2.setName(this.name);
        return concretePrototype2;
    }

    public String toString(){
        return "Now in Prototype2, name = " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
