package com.socialhub.authentication.service;


import com.socialhub.dto.request.LoginRequestDto;

public interface AuthenticationService {
    String login(LoginRequestDto requestDto);

    String logout();

}
