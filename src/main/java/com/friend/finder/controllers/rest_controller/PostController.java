package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @PostMapping("/add")
    public Post addMyPost(@RequestBody Post post){
        return postService.save(post);

    }
    @GetMapping("/show")
    public List<Post> showMyPost(){
        return (List<Post>) postService.findAll();
    }
    @GetMapping("")
    public ModelAndView showNewsFeed(){
        ModelAndView mv = new ModelAndView("newsfeed");
        mv.addObject("post", new Post());
        mv.addObject("comment", new Comment());
        Iterable<Comment> listComment = commentService.findAll();
        mv.addObject("listComment", listComment);
        return mv;
    }


}
