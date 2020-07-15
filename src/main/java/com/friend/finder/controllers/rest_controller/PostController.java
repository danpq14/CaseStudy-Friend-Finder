package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Comment;
import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = {"*"})
@Controller
@RequestMapping("app/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CommentService commentService;
    @GetMapping("")
    public ModelAndView showNewsFeed(Principal principal, Pageable pageable){
        ModelAndView mv = new ModelAndView("newsfeed");
        Account account = accountService.findAccountByUserName(principal.getName());
        Iterable<Post> listPost = postService.getPostsByNewsfeedSetOrderByPostTimeDesc(pageable);
        for (Post post: listPost) {
            Long postID = post.getId();
            List<Comment> listComment = (List<Comment>) commentService.getCommentByNewsfeedSetOrderByPostTimeDesc();
            mv.addObject(postID.toString(), listComment);
        }
        mv.addObject("listPost", listPost);
        mv.addObject("post", new Post());
        mv.addObject("comment", new Comment());
        return mv;
    }
    @GetMapping("/showNewPost")
    public ModelAndView showAllPost(){

        ModelAndView mv = new ModelAndView("newsfeed");
        Iterable<Post> listPost = postService.findAll();
        mv.addObject("listPost", listPost);
        mv.addObject("post", new Post());
        mv.addObject("comment", new Comment());
        return mv;
    }
}
