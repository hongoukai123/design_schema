package com.kai.chap.baseprovide.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kai.chap.baseinterface.HelloService;

@Service
public class DefaultHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }

    @Override
    public String sayGoodbye(String name) {
        return "Goodbye " + name + "!";
    }

}
