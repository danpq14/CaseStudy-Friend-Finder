package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Comment;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("myComment")
public class CommentControllerAPI {
    @Autowired
    CommentService commentService;
    @Autowired
    AccountService accountService;
    @PostMapping("/create")
    public void createComment(@RequestBody Comment comment){
        commentService.save(comment);
    }
//    @PostMapping("/show")
//    public ModelAndView showComment(){
//        ModelAndView mv = new ModelAndView("newsfeed");
//        List<Comment> listComment = (List<Comment>) commentService.findAll();
//        mv.addObject("listComment", listComment);
//        return mv;
    @GetMapping("/show")
    public String showComment(Model model){
        Iterable<Comment> listComment = commentService.findAll();
        model.addAttribute("listComment", listComment);
        return "/newsfeed";
    }
}
