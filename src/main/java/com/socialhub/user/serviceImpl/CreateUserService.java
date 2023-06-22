package com.socialhub.user.serviceImpl;

import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.CreateUserRequestDto;
import com.socialhub.user.entity.User;
import com.socialhub.user.entity.UserImage;
import com.socialhub.user.serviceImpl.daoservice.UserDaoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUserService {

   private UserDaoService userDaoService;




   private ResponseUtil responseUtil;

    public CreateUserService(UserDaoService userDaoService,ResponseUtil responseUtil) {
        this.userDaoService = userDaoService;
        this.responseUtil=responseUtil;
    }


    public ResponseData createUser(CreateUserRequestDto request){

        request.validate();

        UserImage userImage = new UserImage(request.getImage());

       User newUser = new  User(request, List.of(userImage));



        userDaoService.saveUser(newUser);


        return responseUtil.successResponse("User Created Successfully");
    }
}
