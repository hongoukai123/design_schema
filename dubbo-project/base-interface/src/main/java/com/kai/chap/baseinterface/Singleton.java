package com.kai.chap.baseinterface;

/**
 * 单例模式
 */
public class Singleton {

    private Singleton(){
        System.out.println("创建Singleton");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}
