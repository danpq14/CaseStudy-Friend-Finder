package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.*;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/app/newsfeed")
    public ModelAndView getNewsfeed(Principal principal){
        Account account = accountService.findAccountByUserName(principal.getName());
        ModelAndView modelAndView =new ModelAndView("xxx");
        modelAndView.addObject("post",new Post());
        modelAndView.addObject("account",account);
        return modelAndView;
    }
    @PostMapping("/app/newsfeed")
    public ModelAndView postContent(@ModelAttribute Post post){
        return null;
    }


}
