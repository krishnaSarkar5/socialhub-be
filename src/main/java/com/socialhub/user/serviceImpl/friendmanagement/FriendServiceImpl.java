package com.socialhub.user.serviceImpl.friendmanagement;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.service.FriendService;
import org.springframework.stereotype.Service;


@Service
public class FriendServiceImpl implements FriendService {


    private FriendLogService friendLogService;

    public FriendServiceImpl(FriendLogService friendLogService) {
        this.friendLogService=friendLogService;
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
