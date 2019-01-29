package com.kai.chap.structure.adapter.aclass;

/**
 * 适配器角色类
 * <p>
 *     适配器类是本模式是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是类。
 * </p>
 * <p>
 *     适配器角色Adapter扩展了Adaptee，同时又实现了目标（Target）接口。由于Adaptee没有提供simpleOperation2()方法，
 *     因此适配器角色Adapter实现了这个方法。
 * </p>
 * @author hok
 * @since 2019-1-23 15:07:29
 */
public class Adapter extends Adaptee implements Target {

    /**
     * 由于源类Adaptee没有simpleOperation2()
     * 因此适配器补充上这个方法
     */
    public void simpleOperation2() {
        //写相关代码
    }

}
