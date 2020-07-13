package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.repositories.CommentRepository;
import com.friend.finder.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("myComment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("")
    public ModelAndView showNewsFeed(){
        ModelAndView modelAndView = new ModelAndView("newsfeed");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
    @PostMapping("/create")
    public void createComment(@RequestBody Comment comment){
        commentService.save(comment);
    }
}
