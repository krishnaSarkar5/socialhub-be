package com.socialhub.user.repository;


import com.socialhub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndStatus(String email, int status);

    Optional<User> findByIdAndStatus(Long userId,Integer status);


}
