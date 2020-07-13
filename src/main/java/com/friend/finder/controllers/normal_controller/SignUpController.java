package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    AccountService accountService;

    @PostMapping("/signUp")
    public ModelAndView signUpAccount(@ModelAttribute Account account, @Valid BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Account checkAccount = accountService.findAccountByUserName(account.getUsername());
        if (checkAccount != null) {
            modelAndView.addObject("message", "Username Was Existed!!!");
            modelAndView.addObject("account", account);
            modelAndView.setViewName("index");
            return modelAndView;
        } else {
            if (bindingResult.hasFieldErrors()) {
                modelAndView.addObject("account", account);
                modelAndView.setViewName("index");
                return modelAndView;
            }
            try {
                accountService.signUp(account);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.addObject("message", "Sign Up New Account Success ! Please Log in");
            modelAndView.addObject("account", new Account());
            modelAndView.setViewName("login-page");
            return modelAndView;
        }
    }

    @GetMapping("/login-page")
    public ModelAndView loginPage() {
        return new ModelAndView("login-page");
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "index";
    }

}
