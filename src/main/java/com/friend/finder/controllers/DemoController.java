package com.friend.finder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String getContact(){
        return "newsfeed";
    }

}
