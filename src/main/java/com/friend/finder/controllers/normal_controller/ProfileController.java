package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Post;
import com.friend.finder.models.Profile;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private ProfileService profileService;

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
    public ModelAndView saveProfile(@ModelAttribute(name = "profile") Profile newProfile,@ModelAttribute("account") Account account){
        Profile currentProfile = account.getProfile();
        newProfile.setId(currentProfile.getId());
        profileService.save(newProfile);
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile",newProfile);
        return modelAndView;
    }

    @GetMapping("/app/profile/{username}")
    public ModelAndView userProfile(@PathVariable("username") String username,Principal principal){
        Account userAccount = accountService.findAccountByUserName(username);
        Account currentAccount = accountService.findAccountByUserName(principal.getName());
        Profile profile = userAccount.getProfile();
        ModelAndView modelAndView = new ModelAndView("user-profile");
        modelAndView.addObject("account",userAccount);
        modelAndView.addObject("profile",profile);


        boolean isFriend = accountService.checkFriend(currentAccount, userAccount);
        if (isFriend) {
            modelAndView.addObject("message","Friend");
        }
        else {
            modelAndView.addObject("message", "Add Friend");
        }
        return modelAndView;
    }

}
