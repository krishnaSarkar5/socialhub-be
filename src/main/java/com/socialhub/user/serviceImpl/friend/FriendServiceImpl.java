package com.socialhub.user.serviceImpl.friend;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.service.FriendService;
import com.socialhub.user.serviceImpl.daoservice.FriendDaoService;
import com.socialhub.user.serviceImpl.friend.FriendLogService;
import org.springframework.stereotype.Service;


@Service
public class FriendServiceImpl implements FriendService {


    private FriendLogService friendLogService;


    private FriendDaoService friendDaoService;

    public FriendServiceImpl(FriendLogService friendLogService,FriendDaoService friendDaoService) {
        this.friendLogService=friendLogService;
        this.friendDaoService=friendDaoService;
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
        return null;
    }
}
