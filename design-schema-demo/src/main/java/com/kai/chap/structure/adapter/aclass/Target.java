package com.kai.chap.structure.adapter.aclass;

/**
 * 目标角色
 * <p>
 *     就是所期待得到的接口，由于这里讨论的是适配器模式，因此目标不可以是类
 * </p>
 * @author hok
 * @since 2019-1-23 15:02:28
 */
public interface Target {

    /**
     * 这是源类Adaptee也有的方法
     */
    public void simpleOperation1();

    /**
     * 这是源类Adaptee没有的方法
     */
    public void simpleOperation2();

}
