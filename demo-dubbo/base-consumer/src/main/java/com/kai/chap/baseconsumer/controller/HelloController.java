package com.kai.chap.baseconsumer.controller;

import com.kai.chap.baseinterface.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable String name){
        return helloService.sayHello(name);
    }

    @GetMapping("goodbye/{name}")
    public String sayGoodbye(@PathVariable String name){
        return helloService.sayGoodbye(name);
    }

}
