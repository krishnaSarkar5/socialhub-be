package com.socialhub.user.serviceImpl.daoservice;

import com.socialhub.common.enums.FriendAction;
import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.user.entity.FriendLog;
import com.socialhub.user.repository.FriendLogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class FriendLogDaoService {

    private FriendLogRepository friendLogRepository;

    public FriendLogDaoService(FriendLogRepository friendLogRepository) {
        this.friendLogRepository = friendLogRepository;
    }


    public List<FriendLog> getAllFriendRequest(Long userId){
        return friendLogRepository.findAllByRequestedToIdAndActionAndStatusOrderByCreatedAtDesc(userId, FriendAction.FRIEND_REQUEST_SENT.getValue(),ActiveInactiveStatusUtil.getACTIVE());
    }


    public FriendLog saveFriendLod(FriendLog friendLog){
        return friendLogRepository.save(friendLog);
    }

    public Optional<FriendLog> getFriendLog(Long requestedById , Long requestedToId, Integer action){
        return friendLogRepository.findByRequestedByIdAndRequestedToIdAndActionAndStatus(requestedById,requestedToId,action,ActiveInactiveStatusUtil.getACTIVE());
    }

    public List<FriendLog> getAllSentFriendRequest(Long userId){
        return friendLogRepository.findAllByRequestedByIdAndActionAndStatusOrderByCreatedAtDesc(userId, FriendAction.FRIEND_REQUEST_SENT.getValue(),ActiveInactiveStatusUtil.getACTIVE());
    }


    public List<FriendLog> saveFriendLog(List<FriendLog> friendLogList){
        return friendLogRepository.saveAll(friendLogList);
    }


}
