package com.socialhub.user.serviceImpl.daoservice;

import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.user.entity.User;
import com.socialhub.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoService {


    private UserRepository userRepository;


    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }


    public Optional<User> getUserById(Long id){
        return userRepository.findByIdAndStatus(id,ActiveInactiveStatusUtil.getACTIVE());
    }
}
