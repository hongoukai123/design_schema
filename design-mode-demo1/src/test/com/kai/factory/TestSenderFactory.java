package com.kai.factory;

import com.kai.factory.demo1.SenderFactory;

/**
 * 测试普通工厂模式
 */
public class TestSenderFactory {

    public static void main(String[] args){
        SenderFactory senderFactory = new SenderFactory();
        ISender sender = senderFactory.produce("sms");
        sender.send();
    }

}
