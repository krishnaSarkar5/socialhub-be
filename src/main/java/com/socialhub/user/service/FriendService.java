package com.socialhub.user.service;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.AcceptFriendRequestDto;
import com.socialhub.user.dto.friend.FriendActionIdDto;
import com.socialhub.user.dto.friend.IdDto;

public interface FriendService {

    ResponseData sentFriendRequest(IdDto request);


    ResponseData acceptFriendRequest(IdDto request);

    ResponseData getAllSentRequest();


    ResponseData getAllReceivedRequest();


    ResponseData getAllFriends();

//    ResponseData getMutualFriend();


}
