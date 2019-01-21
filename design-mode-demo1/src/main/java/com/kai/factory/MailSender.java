package com.kai.factory;

public class MailSender implements ISender {

    @Override
    public void send() {
        System.out.println("这是发送邮件");
    }

}
