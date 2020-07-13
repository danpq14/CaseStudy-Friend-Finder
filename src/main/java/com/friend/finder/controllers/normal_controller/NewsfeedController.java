package com.friend.finder.controllers.normal_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsfeedController {

    @GetMapping("/app/newsfeed")
    public String getNewsfeed() {
        return "contact";
    }
}
