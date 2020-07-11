package com.friend.finder.controllers;

import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public String getIndexPage(Model model){
        int users = accountService.countAccountByUserName();
        model.addAttribute("users", users);
        return "index";
    }
}
