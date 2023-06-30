package com.socialhub.user.serviceImpl.friend;

import com.socialhub.common.utility.AuthenticationUtil;
import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.FriendResponseDto;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.entity.User;
import com.socialhub.user.service.FriendService;
import com.socialhub.user.serviceImpl.daoservice.FriendDaoService;
import com.socialhub.user.serviceImpl.friend.FriendLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FriendServiceImpl implements FriendService {


    private FriendLogService friendLogService;


    private FriendDaoService friendDaoService;

    private AuthenticationUtil authenticationUtil;

    private ResponseUtil responseUtil;

    public FriendServiceImpl(FriendLogService friendLogService,FriendDaoService friendDaoService,AuthenticationUtil authenticationUtil,ResponseUtil responseUtil) {
        this.friendLogService=friendLogService;
        this.friendDaoService=friendDaoService;
        this.authenticationUtil=authenticationUtil;
        this.responseUtil=responseUtil;
    }

    @Override
    public ResponseData sentFriendRequest(IdDto request) {
        return friendLogService.sentFriendRequest(request);
    }

    @Override
    public ResponseData acceptFriendRequest(IdDto request) {
        return friendLogService.acceptFriendRequest(request);
    }

    @Override
    public ResponseData getAllSentRequest() {
        return friendLogService.getSentFriendRequestList();
    }

    @Override
    public ResponseData getAllReceivedRequest() {

        return friendLogService.getReceivedFriendRequestList();
    }

    @Override
    public ResponseData getAllFriends() {

        User loggedInUser = getLoggedInUser();

        List<User> allFriends = friendDaoService.getAllFriends(loggedInUser.getId());

        List<FriendResponseDto> friendListResponseDTo = allFriends.stream().map(f -> new FriendResponseDto(f)).collect(Collectors.toList());

        return responseUtil.successResponse(friendListResponseDTo);
    }



    private User getLoggedInUser(){
        return (User) authenticationUtil.currentLoggedInUser().getUser();
    }



}
