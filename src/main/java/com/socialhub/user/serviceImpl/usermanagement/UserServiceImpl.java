package com.socialhub.user.serviceImpl.usermanagement;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.user.CreateUserRequestDto;
import com.socialhub.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private CreateUserService createUserService;

    private GetUserService getUserService;

    public UserServiceImpl(CreateUserService createUserService,GetUserService getUserService) {
        this.createUserService = createUserService;
        this.getUserService=getUserService;
    }

    @Override
    public ResponseData createUser(CreateUserRequestDto request) {
        return createUserService.createUser(request);
    }

    @Override
    public ResponseData getLoggedInUser() {
        return getUserService.getLoggedInUser();
    }
}
