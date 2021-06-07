package com.auth2.auth2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.auth2.auth2.Repository.UserRepository;
import com.auth2.auth2.entity.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Collections;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
public class DefaultAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServices userServices;
	public DefaultAuthenticationProvider(UserServices userServices2) {
		this.userServices=userServices2;
	}

	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.print("Authenticatin"+authentication.getName());
	   Optional<User> appUser =userServices.getByUsername(authentication.getName());
       
        if(appUser.isPresent()) {
        	User user = appUser.get();
            String username = authentication.getName();
            String password = (String)authentication.getCredentials();
            if(username.equalsIgnoreCase(user.getUsername()) &&
                password.equalsIgnoreCase(user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority(user.getRoles()))
                );
            }
        }
        
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
