package com.socialhub.user.serviceImpl.friendmanagement;

import com.socialhub.common.enums.FriendAction;
import com.socialhub.common.exception.ServiceException;
import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.common.utility.AuthenticationUtil;
import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.entity.FriendLog;
import com.socialhub.user.entity.User;
import com.socialhub.user.serviceImpl.daoservice.FriendLogDaoService;
import com.socialhub.user.serviceImpl.daoservice.UserDaoService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class FriendLogService {



    private FriendLogDaoService friendLogDaoService;


    private AuthenticationUtil authenticationUtil;


    private UserDaoService userDaoService;


    private ResponseUtil responseUtil;

    public FriendLogService(FriendLogDaoService friendLogDaoService,AuthenticationUtil authenticationUtil,UserDaoService userDaoService,ResponseUtil responseUtil) {
        this.friendLogDaoService = friendLogDaoService;
        this.authenticationUtil = authenticationUtil;
        this.userDaoService = userDaoService;
        this.responseUtil=responseUtil;
    }


    public ResponseData sentFriendRequest(IdDto request){

        User loggedInUser = getLoggedInUser();

        User requestToUser = getUser(request.getId());

        FriendLog friendLogEntity = getFriendLogEntity(loggedInUser, requestToUser);

        saveFriendLog(friendLogEntity);

        return responseUtil.successResponse("Friend Request Sent");

    }



    private User getLoggedInUser(){
        return (User) authenticationUtil.currentLoggedInUser().getUser();
    }

    private User getUser(Long id){
        return userDaoService.getUserById(id).orElseThrow(()->new ServiceException(Map.of("message","User nor found ")));
    }

    private FriendLog getFriendLogEntity(User requestedBy , User requestedTo){

      return FriendLog.builder()
                .requestedBy(requestedBy)
                .requestedTo(requestedTo)
                .status(ActiveInactiveStatusUtil.getACTIVE())
                .action(FriendAction.FRIEND_REQUEST_SENT.getValue())
                .build();
    }

    private FriendLog saveFriendLog(FriendLog friendLog){
       return friendLogDaoService.saveFriendLod(friendLog);
    }






    public ResponseData acceptFriendRequest(IdDto idDto){
        User loggedInUser = getLoggedInUser();

        User requestByUser = getUser(idDto.getId());

        FriendLog friendLog = getFriendLog(requestByUser, loggedInUser);

        FriendLog newFriendLog = new FriendLog(friendLog);

        newFriendLog.setAction(FriendAction.FRIEND_REQUEST_ACCEPT.getValue());

        friendLog.setStatus(ActiveInactiveStatusUtil.getINACTIVE());

        friendLogDaoService.saveFriendLog(List.of(friendLog,newFriendLog));

        return responseUtil.successResponse("Friend request accepted",null);
    }


    private FriendLog getFriendLog(User requestBy ,User requestTo){
       return friendLogDaoService.getFriendLog(requestBy.getId(),requestTo.getId(),FriendAction.FRIEND_REQUEST_SENT.getValue()).orElseThrow(()->new ServiceException(Map.of("message","Friend Request not found")));
    }












}
