package com.kai.factory.demo1;

import com.kai.factory.ISender;
import com.kai.factory.MailSender;
import com.kai.factory.SmsSender;

/**
 * 多个工厂方法模式
 */
public class SenderMultiFactory {

    public ISender mailSender(){
        return new MailSender();
    }

    public ISender smsSender(){
        return new SmsSender();
    }

}
