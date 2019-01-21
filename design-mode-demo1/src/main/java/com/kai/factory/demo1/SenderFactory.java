package com.kai.factory.demo1;

import com.kai.factory.ISender;
import com.kai.factory.MailSender;
import com.kai.factory.SmsSender;

/**
 * 普通工厂类
 */
public class SenderFactory {

    public ISender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        } else if ("sms".equals(type)){
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }

}
