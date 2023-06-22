package com.socialhub.common.security;




import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.user.entity.User;
import com.socialhub.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class JwtUserDetailService implements UserDetailsService{


	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		return getUser(username);
	}




	private UserDetails getUser(String email){

		User user = userRepository.findByEmailAndStatus(email, 1).orElseThrow(() -> new UsernameNotFoundException("User name not found"));

		boolean isActive = user.getStatus().equals(ActiveInactiveStatusUtil.getACTIVE())?true:false;

		UserDetails userDetails = new JwtUserDetails(user, Arrays.asList(user.getRole()),isActive);

		return  userDetails;

	}


}
