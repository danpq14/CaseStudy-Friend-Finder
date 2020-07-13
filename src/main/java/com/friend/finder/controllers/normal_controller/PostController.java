package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Post;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/add")
    public ResponseEntity<Void> addPost(@RequestBody Post post){
        postService.save(post);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
