package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import com.friend.finder.models.Profile;
import com.friend.finder.services.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    @PostMapping("/create")
    public void createPost(@RequestBody Post post, Principal principal){
        String username = principal.getName();
        Account account = accountService.findAccountByUserName(username);
        post.setAccount(account);
        postService.save(post);
    }
}
