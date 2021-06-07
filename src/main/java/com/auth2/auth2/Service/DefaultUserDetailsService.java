package com.auth2.auth2.Service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

	 @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        String defaultUserName = "admin@gmail.com";
	        String password = encoder.encode("admin");
	        if(!defaultUserName.equalsIgnoreCase(userName)) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        UserDetails userDetails = User.builder()
	                .username(userName)
	                .password(password)
	                .authorities(Collections.emptyList())
	                .build();

	        return userDetails;
	    }

}
