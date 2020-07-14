package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Post;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class TimelineController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PostService postService;

    @GetMapping("/app/timeline")
    public ModelAndView getTimeline(Principal principal, @PageableDefault(size = 5)Pageable pageable) {
        Account account = accountService.findAccountByUserName(principal.getName());
        ModelAndView modelAndView = new ModelAndView("timeline");
        Page<Post> postList = postService.getPostsByAccountOrderByPostTime(account,pageable);
        modelAndView.addObject("account",account);
        modelAndView.addObject("postList",postList);
        return modelAndView;
    }
}
