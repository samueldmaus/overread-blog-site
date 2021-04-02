package com.overread.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void addUser(User user)
	{
		userRepo.save(user);
	}
	
	public User findUserByUsername(String username)
	{
		return userRepo.findUserByUsername(username);
	}
}
