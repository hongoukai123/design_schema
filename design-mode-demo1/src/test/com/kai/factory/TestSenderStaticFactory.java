package com.kai.factory;

import com.kai.factory.demo1.SenderStaticFactory;

/**
 * 测试多个静态工厂方法模式
 */
public class TestSenderStaticFactory {

    public static void main(String[] args){
        ISender sender = SenderStaticFactory.smsSender();
        sender.send();
    }

}
