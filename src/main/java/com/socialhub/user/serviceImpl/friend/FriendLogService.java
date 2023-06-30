package com.socialhub.user.serviceImpl.friend;

import com.socialhub.common.enums.FriendAction;
import com.socialhub.common.exception.ServiceException;
import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.common.utility.AuthenticationUtil;
import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.friend.FriendRequestResponseDto;
import com.socialhub.user.dto.friend.IdDto;
import com.socialhub.user.entity.Friend;
import com.socialhub.user.entity.FriendLog;
import com.socialhub.user.entity.User;
import com.socialhub.user.serviceImpl.daoservice.FriendDaoService;
import com.socialhub.user.serviceImpl.daoservice.FriendLogDaoService;
import com.socialhub.user.serviceImpl.daoservice.UserDaoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FriendLogService {



    private FriendLogDaoService friendLogDaoService;


    private AuthenticationUtil authenticationUtil;


    private UserDaoService userDaoService;


    private ResponseUtil responseUtil;


    private FriendDaoService friendDaoService;

    public FriendLogService(FriendLogDaoService friendLogDaoService,AuthenticationUtil authenticationUtil,UserDaoService userDaoService,ResponseUtil responseUtil,FriendDaoService friendDaoService) {
        this.friendLogDaoService = friendLogDaoService;
        this.authenticationUtil = authenticationUtil;
        this.userDaoService = userDaoService;
        this.responseUtil=responseUtil;
        this.friendDaoService=friendDaoService;
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

        Friend friendEntity = getFriendEntity(requestByUser, loggedInUser);

        saveFriend(friendEntity);

        return responseUtil.successResponse("Friend request accepted",null);
    }


    private FriendLog getFriendLog(User requestBy ,User requestTo){
       return friendLogDaoService.getFriendLog(requestBy.getId(),requestTo.getId(),FriendAction.FRIEND_REQUEST_SENT.getValue()).orElseThrow(()->new ServiceException(Map.of("message","Friend Request not found")));
    }


    private Friend getFriendEntity(User requestedBy,User requestedTo){
       return Friend.builder()
                .user1(requestedBy)
                .user2(requestedTo)
                .status(ActiveInactiveStatusUtil.getACTIVE())
                .build();
    }

    private Friend saveFriend(Friend friend){
        return friendDaoService.saveFriend(friend);
    }



    public ResponseData getReceivedFriendRequestList(){

        User loggedInUser = getLoggedInUser();

        List<FriendLog> friendLogList = getAllReceivedFriendLog(loggedInUser.getId());

        List<FriendRequestResponseDto> friendRequestResponseDtos = convertEntityListTODtoList(friendLogList);

        return responseUtil.successResponse(friendRequestResponseDtos);


    }


    private List<FriendLog> getAllReceivedFriendLog(Long userId){
        return friendLogDaoService.getAllReceivedFriendRequest(userId);
    }


    private List<FriendRequestResponseDto> convertEntityListTODtoList(List<FriendLog> friendLogList){
       return friendLogList.stream().map(fl->new FriendRequestResponseDto(fl.getRequestedTo(),fl.getCreatedAt())).collect(Collectors.toList());
    }












    public ResponseData getSentFriendRequestList(){

        User loggedInUser = getLoggedInUser();

        List<FriendLog> sentFriendLogList = getSentFriendLogList(loggedInUser.getId());

        List<FriendRequestResponseDto> sentFriendRequestResponseDtos = convertEntityListTODtoList(sentFriendLogList);

        return responseUtil.successResponse(sentFriendRequestResponseDtos);

    }





    private List<FriendLog> getSentFriendLogList(Long userId){
        return friendLogDaoService.getAllSentFriendRequest(userId);
    }





}
