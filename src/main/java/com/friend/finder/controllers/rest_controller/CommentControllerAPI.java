package com.friend.finder.controllers.rest_controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friend.finder.models.Account;
import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import com.friend.finder.models.Profile;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("app/myComment")
public class CommentControllerAPI {
    @Autowired
    CommentService commentService;
    @Autowired
    AccountService accountService;
    @Autowired
    PostService postService;
    @PostMapping("/create/{id}")
    public ResponseEntity<Comment> createComment(@PathVariable Long id, @RequestBody Comment comment, Principal principal){
        Account account = accountService.findAccountByUserName(principal.getName()) ;
        Post post = postService.findById(id).get();
        comment.setAccount(account);
        comment.setPost(post);
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @GetMapping("/show")
    public ResponseEntity<Iterable<Comment>> showComment(){
        Iterable<Comment> listComment = commentService.findAll();
        return new ResponseEntity<>(listComment, HttpStatus.OK);
    }
    @GetMapping("/showAComment/{id}")
    public Comment showAComment(@PathVariable Long id){
        Comment comment = commentService.findById(id).get();
        return comment;
    }
    @GetMapping("/lastname/{id}")
    public ResponseEntity<String> getLastNameByAccount(@PathVariable Long id){
        Comment comment = commentService.findById(id).get();
        String userName = comment.getAccount().getProfile().getLastName();
        return new ResponseEntity<>(userName, HttpStatus.CREATED);
    }

}
