package com.socialhub.authentication.ServiceImpl;


import com.socialhub.dto.request.LoginRequestDto;
import com.socialhub.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private LoginService loginService;
    @Override
    public String login(LoginRequestDto requestDto) {
        return loginService.login(requestDto);
    }

    @Override
    public String logout() {
        return null;
    }
}
