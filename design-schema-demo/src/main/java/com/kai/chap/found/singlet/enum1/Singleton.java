package com.kai.chap.found.singlet.enum1;

/**
 * 枚举单例模式
 * @author hok
 * @since 2019-1-22 16:41:47
 */
public enum Singleton {

    /**
     * 定义一个枚举元素，它就代表了Singleton的一个实例
     */
    uniqueInstance;

    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation(){
        //功能处理
    }

}
