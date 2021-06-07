package com.auth2.auth2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth2.auth2.Repository.UserRepository;
import com.auth2.auth2.entity.User;

@Service
public class UserServices  {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getByUsername(@RequestParam("username") String  username) {
		
		return Optional.of(userRepository.findByUsername(username));
	}
}
