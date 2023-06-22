package com.socialhub.user.serviceImpl.daoservice;

import com.socialhub.common.exception.ServiceException;
import com.socialhub.common.utility.AuthenticationUtil;
import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.GetUserResponseDto;
import com.socialhub.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetUserService {


    private UserDaoService userDaoService;

    private AuthenticationUtil authenticationUtil;

    private ResponseUtil responseUtil;

    public GetUserService(UserDaoService userDaoService,AuthenticationUtil authenticationUtil,ResponseUtil responseUtil) {
        this.userDaoService = userDaoService;
        this.authenticationUtil=authenticationUtil;
        this.responseUtil=responseUtil;
    }


    public ResponseData getLoggedInUser(){
        User loggedInuser = (User) authenticationUtil.currentLoggedInUser().getUser();

        User user = userDaoService.getUserById(loggedInuser.getId()).orElseThrow(() -> new ServiceException(Map.of("message", "No User found")));

        GetUserResponseDto getUserResponseDto = new GetUserResponseDto(user);

        return responseUtil.successResponse(getUserResponseDto);
    }
}
