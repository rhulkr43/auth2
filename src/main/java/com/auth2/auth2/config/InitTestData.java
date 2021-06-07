package com.auth2.auth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.auth2.auth2.Repository.PostRepository;
import com.auth2.auth2.Repository.UserRepository;
import com.auth2.auth2.entity.Post;
import com.auth2.auth2.entity.User;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ApplicationContextEvent;
@Component
@Log4j2
public class InitTestData implements ApplicationListener<ApplicationContextEvent> {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
    	User user=new User();
    	user.setRoles("USER");
    	user.setPassword("admin");
    	user.setUsername("admin@gmail.com");
        //userRepository.save(user);
        
       
    }
}