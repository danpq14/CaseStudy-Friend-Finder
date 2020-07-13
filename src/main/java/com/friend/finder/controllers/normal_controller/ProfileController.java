package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@SessionAttributes("account")
public class ProfileController {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public Account getAccount(Principal principal) {
        Account account = accountService.findAccountByUserName(principal.getName());
        return account;
    }
    @GetMapping("/app/profile")
    public String showTimelinePage(Model model, @ModelAttribute("account") Account account){
        Profile profile = account.getProfile();
        model.addAttribute("profile",profile);
        return "profile";
    }

    @GetMapping("/app/profile-edit")
    public ModelAndView editInfoPage(@ModelAttribute("account") Account account){
        ModelAndView modelAndView = new ModelAndView("profile-editing");
        Profile profile = account.getProfile();
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }
    @PostMapping("/app/profile-edit")
    public ModelAndView saveProfile(@ModelAttribute Profile profiles,@ModelAttribute("account") Account account){
        account.setProfile(profiles);
        Profile profile = account.getProfile();
        accountService.save(account);
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }
}
