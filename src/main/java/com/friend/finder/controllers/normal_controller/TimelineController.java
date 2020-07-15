package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.*;
import com.friend.finder.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class TimelineController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NewsfeedService newsfeedService;

    @Autowired
    private PostService postService;

    @GetMapping("/app/timeline")
    public String getTimeline(Principal principal, Model model, @PageableDefault(size = 8) Pageable pageable) {
        String username = principal.getName();
        Account account = accountService.findAccountByUserName(username);
        Profile profile = account.getProfile();
        Timeline timeline = account.getTimeline();
        Newsfeed newsfeed = newsfeedService.getNewsfeedByAccount(account);
        Page<Post> posts = postService.getPostsByNewsfeedSetOrderByPostTimeDesc(newsfeed,pageable);
        model.addAttribute("posts", posts);
        model.addAttribute("profile", profile);
        if (isNewUser(profile)){
            return "profile-editing";
        }
        return "timeline";
    }


    public boolean isNewUser(Profile profile){
        String fullName = profile.getFirstName() + " " + profile.getLastName();
        if (fullName.equalsIgnoreCase("New User")) {
            return true;
        }
        return false;
    }

    @GetMapping("/app/timeline/{username}")
    public ModelAndView viewTimeline(@PathVariable String username, @PageableDefault(size = 5)Pageable pageable, Principal principal ) {
        Account account = accountService.findAccountByUserName(username);
        Profile profile = account.getProfile();
        ModelAndView modelAndView = new ModelAndView("timeline-friends");
        Page<Post> postList = postService.getPostsByAccountOrderByPostTime(account,pageable);
        modelAndView.addObject("account",account);
        modelAndView.addObject("postList",postList);

        Account currentAccount = accountService.findAccountByUserName(principal.getName());

        boolean isFriend = accountService.checkFriend(currentAccount, account);
        if (isFriend) {
            modelAndView.addObject("message","Friend");
        }
        else {
            modelAndView.addObject("message", "Add Friend");
        }
        return modelAndView;
    }


}
