package com.kai.factory;

import com.kai.factory.demo1.SenderMultiFactory;

/**
 * 测试多个工厂方法模式
 */
public class TestSenderMultiFactory {

    public static void main(String[] args){
        SenderMultiFactory senderMultiFactory = new SenderMultiFactory();
        ISender sender = senderMultiFactory.smsSender();
        sender.send();
    }

}
