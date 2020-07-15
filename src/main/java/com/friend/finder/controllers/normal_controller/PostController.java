package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.*;
import com.friend.finder.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private NewsfeedService newsfeedService;

    @PostMapping("/app/create-post")
    public ModelAndView createPost(Principal principal, Pageable pageable,
                                   @RequestParam(name = "texts") String content,
                                   @RequestParam(name = "imghref") String href) {
        Account account = accountService.findAccountByUserName(principal.getName());
        Post post = new Post();
        Image image = new Image();
        if (href == null || href == "") {
            image = null;
        }
        else {
            image.setHref(href);
        }
        post.setAccount(account);
        post.setContent(content);
        post.setImages(imageService.save(image));


        List<Account> friends = account.getFriends();
        List<Newsfeed> friendNewsfeed = new ArrayList<>();
        for (Account fr : friends) {
            friendNewsfeed.add(fr.getNewsfeed());
        }
        for (Newsfeed newsfeed : friendNewsfeed) {
            newsfeed.getPostSet().add(postService.save(post));
            newsfeedService.save(newsfeed);
        }
        Profile profile = account.getProfile();
        ModelAndView modelAndView = new ModelAndView("abc");
        Page<Post> postList = postService.getPostsByAccountOrderByPostTime(account,pageable);
        modelAndView.addObject("account",account);
        modelAndView.addObject("postList",postList);
        modelAndView.addObject("profile",profile);
        return modelAndView;

    }

}
