package com.kai.chap.found.prototype.register;

/**
 * 抽象原型角色
 * @author hok
 * @since 2019-1-16 16:46:19
 */
public interface Prototype {

    public Prototype clone();

    public String getName();

    public void setName(String name);

}
