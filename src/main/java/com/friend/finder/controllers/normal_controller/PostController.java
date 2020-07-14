package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Post addMyPost(@RequestBody Post post) {
        return postService.save(post);

    }

    @GetMapping("/show")
    public List<Post> showMyPost() {
        return (List<Post>) postService.findAll();
    }

    @GetMapping("")
    public ModelAndView showNewsFeed() {
        ModelAndView mv = new ModelAndView("newsfeed");
        mv.addObject("post", new Post());
        mv.addObject("comment", new Comment());
        Iterable<Comment> listComment = commentService.findAll();
        mv.addObject("listComment", listComment);
        return mv;
    }


}
