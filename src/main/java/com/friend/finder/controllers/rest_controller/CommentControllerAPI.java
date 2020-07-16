package com.friend.finder.controllers.rest_controller;

import com.friend.finder.modelFake.CommentFake;
import com.friend.finder.modelFake.CommentResponse;
import com.friend.finder.models.Account;
import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CommentControllerAPI {
    @Autowired
    CommentService commentService;
    @Autowired
    AccountService accountService;
    @Autowired
    private PostService postService;

    @PostMapping("/create-comment")
    public void createComment(@RequestBody Comment comment) {
        Post post=postService.findById(comment.getPost().getId()).get();
        Account account=accountService.findById(comment.getAccount().getId());
        comment.setAccount(account);
        comment.setPost(post);
        commentService.save(comment);
    }

    @GetMapping("/get-comments/{postId}")
    public CommentResponse showComment(@PathVariable Long postId) {
        Post post=postService.findById(postId).get();
        List<CommentFake> list=new ArrayList<>();
        CommentFake commentFake=new CommentFake();
        List<Comment>list1=commentService.findCommentsByPost(post);
        list=commentFake.getContentComment(list1);

        CommentResponse response = new CommentResponse(postId, list);
        return response;
    }


}
