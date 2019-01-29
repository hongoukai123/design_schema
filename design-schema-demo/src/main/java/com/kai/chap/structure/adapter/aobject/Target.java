package com.kai.chap.structure.adapter.aobject;

/**
 * 目标角色类
 * @author hok
 * @since 2019-1-23 15:17:44
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
