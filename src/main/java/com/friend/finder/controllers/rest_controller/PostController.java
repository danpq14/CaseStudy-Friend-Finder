package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = {"*"})
@Controller
@RequestMapping("app/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @GetMapping("")
    public ModelAndView showNewsFeed(){
        Iterable<Post> listPost = postService.findAll();
        ModelAndView mv = new ModelAndView("newsfeed");
        mv.addObject("post", new Post());
        mv.addObject("comment", new Comment());
        mv.addObject("listPost", listPost);
        return mv;
    }
}
