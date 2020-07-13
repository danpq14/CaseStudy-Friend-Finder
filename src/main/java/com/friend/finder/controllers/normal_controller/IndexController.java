package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
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
    public String getIndex(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getIndexPage(Model model){
        Account account = new Account();

        model.addAttribute("account", account);
        return "index";
    }
    @GetMapping("/app/timeline")
    public String getTimeline(){
        return "timeline";
    }
}
