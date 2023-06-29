package com.socialhub.user.repository;

import com.socialhub.user.entity.FriendLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendLogRepository extends JpaRepository<FriendLog,Long> {

    List<FriendLog> findAllByRequestedToIdAndActionAndStatusOrderByCreatedAtDesc(Long userId, Integer action, Integer status);


    List<FriendLog> findAllByRequestedByIdAndActionAndStatusOrderByCreatedAtDesc(Long userId, Integer action, Integer status);


    Optional<FriendLog> findByRequestedByIdAndRequestedToIdAndActionAndStatus(Long requestedBy, Long requestTo,Integer action,Integer status);


}
