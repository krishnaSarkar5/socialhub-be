package com.socialhub.common.security;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String email;
	
	private String password;
}
