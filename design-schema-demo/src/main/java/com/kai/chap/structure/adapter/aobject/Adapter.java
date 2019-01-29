package com.kai.chap.structure.adapter.aobject;

/**
 * 适配器角色类
 * @author hok
 * @since 2019-1-23 15:20:26
 */
public class Adapter extends Adaptee implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    /**
     * 源类Target有方法simpleOperation1
     * 因此适配器直接委派即可
     */
    public void simpleOperation1(){
        this.adaptee.simpleOperation1();
    }

    /**
     * 源类Target没有方法simpleOperation2
     * 因此适配器类需要补充此方法
     */
    public void simpleOperation2() {
        //写相关的代码
    }

}
