package com.kai.factory;

public class SmsSender implements ISender {

    @Override
    public void send() {
        System.out.println("这是发送短信");
    }

}
