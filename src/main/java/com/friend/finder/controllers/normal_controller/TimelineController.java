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

import java.security.Principal;

@Controller
public class TimelineController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NewsfeedService newsfeedService;

    @Autowired
    private PostService postService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TimelineService timelineService;

    @GetMapping("/app/timeline")
    public String getTimeline(Principal principal, Model model, @PageableDefault(size = 8) Pageable pageable) {
        String username = principal.getName();
        Account account = accountService.findAccountByUserName(username);
        Profile profile = account.getProfile();
        Timeline timeline = account.getTimeline();
        Newsfeed newsfeed = newsfeedService.getNewsfeedByAccount(account);
        Page<Post> posts = postService.getPostsByNewsfeedSetOrderByPostTimeDesc(pageable);
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
}
