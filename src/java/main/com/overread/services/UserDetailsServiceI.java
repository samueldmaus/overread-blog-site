package com.overread.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.User;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service("userDetailsService")
public class UserDetailsServiceI implements UserDetailsService
{
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userService.findUser(username);
		UserBuilder builder = null;
		if(user != null)
		{
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			
		}
		return builder.build();
	}
}
