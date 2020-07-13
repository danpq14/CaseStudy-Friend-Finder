package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/app/profile")
    public String showTimelinePage(Model model, Principal principal){
        Account account = accountService.findAccountByUserName(principal.getName());
        Profile profile = account.getProfile();
        model.addAttribute("profile",profile);
        return "profile";
    }

//    @GetMapping("/timeline-edit")
//    public ModelAndView editInfoPage(){
//        ModelAndView modelAndView = new ModelAndView("edit-timeline-about");
//        modelAndView.addObject("profile",profile);
//        return modelAndView;
//    }
//    @PostMapping("/timeline-edit")
//    public ModelAndView saveProfile(@ModelAttribute Profile profiles){
//        profile = profiles;
//        ModelAndView modelAndView = new ModelAndView("profile");
//        modelAndView.addObject("profile",profile);
//        return modelAndView;
//    }
}
