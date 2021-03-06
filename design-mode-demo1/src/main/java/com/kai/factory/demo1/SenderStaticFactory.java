package com.kai.factory.demo1;

import com.kai.factory.ISender;
import com.kai.factory.MailSender;
import com.kai.factory.SmsSender;

/**
 * 静态工厂方法模式
 */
public class SenderStaticFactory {

    public static ISender mailSender(){
        return new MailSender();
    }

    public static ISender smsSender(){
        return new SmsSender();
    }

}
