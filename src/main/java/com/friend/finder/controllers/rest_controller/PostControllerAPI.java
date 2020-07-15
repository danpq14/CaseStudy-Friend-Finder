package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import com.friend.finder.models.Profile;
import com.friend.finder.services.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/app/post")
public class PostControllerAPI {
    @Autowired
    PostService postService;
    @Autowired
    AccountService accountService;
    @Autowired
    ProfileService profileService;
    @Autowired
    NewsfeedService newsfeedService;
//    @GetMapping("/create")
//    public List<Post> getAllPost(){
//        return (List<Post>) postService.findAll();
//    }
    @PostMapping("/create")
    public Post createPost(@RequestBody Post post, Principal principal){
        String username = principal.getName();
        Account account = accountService.findAccountByUserName(username);
        post.setAccount(account);
        postService.save(post);
        return post;
    }
    @GetMapping("/show")
    public ResponseEntity<Iterable<Post>> showAllPost(){
        Iterable<Post> listPost = postService.findAll();
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

}
