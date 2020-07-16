package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import com.friend.finder.models.Profile;
import com.friend.finder.repositories.NewsfeedRepository;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.NewsfeedService;
import com.friend.finder.services.PostService;
import com.friend.finder.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.security.Principal;
import java.util.Set;

@Controller
public class NewsfeedController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NewsfeedService newsfeedService;

    @Autowired
    private PostService postService;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/app/newsfeed")
    public String getNewsfeed(Principal principal, Model model, @PageableDefault(size = 8)Pageable pageable) {
        String username = principal.getName();
        Account account = accountService.findAccountByUserName(username);
        Profile profile = account.getProfile();
        Newsfeed newsfeed = newsfeedService.getNewsfeedByAccount(account);
        Page<Post> posts = postService.getPostsByNewsfeedSetOrderByPostTimeDesc(newsfeed,pageable);
        model.addAttribute("account", account);
        model.addAttribute("postList", posts);
        model.addAttribute("profile", profile);

        return "newsfeed";
    }

}
