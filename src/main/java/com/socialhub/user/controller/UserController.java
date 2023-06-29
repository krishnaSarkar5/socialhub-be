package com.socialhub.user.controller;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.user.CreateUserRequestDto;
import com.socialhub.user.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    private ResponseEntity<ResponseData> createUser(@RequestBody CreateUserRequestDto request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    private ResponseEntity<ResponseData> getLoggedInUser(){
        return new ResponseEntity<>(userService.getLoggedInUser(), HttpStatus.OK);
    }

}
