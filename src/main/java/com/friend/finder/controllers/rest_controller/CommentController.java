package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("myComment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    AccountService accountService;
    @GetMapping("")
    public ModelAndView showNewsFeed(Principal principal){
        Iterable<Comment> listComment = commentService.findAll();
        ModelAndView modelAndView = new ModelAndView("newsfeed");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("listComment", listComment);
//        String user_name = principal.getName();
//        modelAndView.addObject("user_name", accountService.findAccountByUserName(user_name).getId());
        return modelAndView;
    }

}
