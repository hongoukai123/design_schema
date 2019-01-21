package com.example.sendemail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSendEmail {

    @GetMapping("/")
    public String sendEmail(){
        return "index.html";
    }



}
