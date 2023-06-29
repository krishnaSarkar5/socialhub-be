package com.socialhub.user.service;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.AcceptFriendRequestDto;
import com.socialhub.user.dto.friend.FriendActionIdDto;

public interface FriendService {

    ResponseData sentFriendRequestAction(FriendActionIdDto request);


    ResponseData getAllSentRequest();


    ResponseData getAllReceivedRequest();


    ResponseData getAllFriends();

//    ResponseData getMutualFriend();


}
