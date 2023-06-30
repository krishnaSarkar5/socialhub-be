package com.socialhub.user.serviceImpl.daoservice;

import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.user.entity.Friend;
import com.socialhub.user.entity.User;
import com.socialhub.user.repository.FriendRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FriendDaoService {


    private FriendRepository friendRepository;





    public FriendDaoService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }



    public Friend saveFriend(Friend friend){
        return friendRepository.save(friend);
    }


    public Optional<Friend> checkFriendExists(Long userId1 ,Long userId2){
        return friendRepository.checkFriendExists(userId1,userId2,ActiveInactiveStatusUtil.getACTIVE());
    }


    public List<User> getAllFriends(Long user1){
        List<Friend> allFriends = friendRepository.findAllFriendsWithStatus(user1, ActiveInactiveStatusUtil.getACTIVE());


        List<User> friendList = allFriends.stream().map((friend -> friend.getUser1().getId().equals(user1) ? friend.getUser2() : friend.getUser1())).collect(Collectors.toList());

        return friendList;
    }


}
