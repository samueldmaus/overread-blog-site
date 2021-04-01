package com.overread.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.User;
import com.overread.repositories.UserRepository;

@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void addUser(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	public User findUser(String username)
	{
		return userRepo.findByUsername(username);
	}
}
