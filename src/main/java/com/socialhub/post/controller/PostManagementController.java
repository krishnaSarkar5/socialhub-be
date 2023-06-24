package com.socialhub.post.controller;


import com.socialhub.dto.ResponseData;
import com.socialhub.post.service.PostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostManagementController {


    private PostService postService;


    public PostManagementController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/all-post")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ResponseData> getAllPostForCurrentLoggedInUser(){
        return new ResponseEntity<>(postService.getAllPostForCurrentLoggedInUser(), HttpStatus.OK);
    }
}
