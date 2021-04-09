package com.overread.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.Authorities;
import com.overread.models.User;
import com.overread.repositories.AuthoritiesRepository;

@Service
@Transactional
public class AuthoritiesService
{
	@Autowired
	private AuthoritiesRepository authRepo;
	
	public AuthoritiesService() {}
	
	public AuthoritiesService(AuthoritiesRepository authRepo)
	{
		this.authRepo = authRepo;
	}
	
	public Authorities addUserAuth(Authorities auth)
	{
		return authRepo.save(auth);
	}
	
	public Iterable<Authorities> getAllAuths()
	{
		return authRepo.findAll();
	}
}
