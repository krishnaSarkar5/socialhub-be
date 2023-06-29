package com.socialhub.user.controller;


import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.service.FriendService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
public class FriendController {

    private FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/sent-friend-request")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ResponseData> sentFriendRequest(@RequestBody IdDto idDto){
        return new ResponseEntity<>(friendService.sentFriendRequest(idDto), HttpStatus.OK);
    }


    @PostMapping("/accept-friend-request")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ResponseData> acceptFriendRequest(@RequestBody IdDto idDto){
        return new ResponseEntity<>(friendService.acceptFriendRequest(idDto),HttpStatus.OK);
    }
}
