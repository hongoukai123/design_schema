package com.kai.chap.found.prototype.easy;

/**
 * 抽象原型角色
 * @author hok
 * @since 2019-1-16 15:09:08
 */
public interface Prototype {

    /**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
    public Object clone();

}
