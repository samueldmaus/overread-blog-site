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
	
	public UserService() {}
	
	public UserService(UserRepository userRepo)
	{
		this.userRepo = userRepo;
	}
	
	public User addUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findUserByUsername(String username)
	{
		return userRepo.findUserByUsername(username);
	}
	
	public void updateUserPicture(String username, byte[] p)
	{
		userRepo.updateUserPicture(username, p);
	}
	
	public void updatePassword(String username, String password)
	{
		userRepo.updatePassword(username, password);
	}
}
