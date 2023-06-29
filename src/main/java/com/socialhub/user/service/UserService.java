package com.socialhub.user.service;

import com.socialhub.dto.ResponseData;
import com.socialhub.user.dto.user.CreateUserRequestDto;

public interface UserService {

    ResponseData createUser(CreateUserRequestDto request);

    ResponseData getLoggedInUser();

}
