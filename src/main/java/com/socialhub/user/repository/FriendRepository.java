package com.socialhub.user.repository;

import com.socialhub.user.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend,Long> {


    @Query(value = "select * from friend where (user1 = ?1 and user2 = ?2 and status = ?3) or (user1 = ?2 and user2 = ?1 and status = ?3) " , nativeQuery = true)
    Optional<Friend>   checkFriendExists(Long user1Id , Long user2Id,Integer status);

    @Query(value = "select * from friend where (user1 = ?1 or user2 = ?2) and status = ?2" , nativeQuery = true)
    List<Friend> findAllFriends(Long userId,Integer status);





}
