package com.overread.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.Authorities;
import com.overread.repositories.AuthoritiesRepository;

@Service
@Transactional
public class AuthoritiesService
{
	@Autowired
	private AuthoritiesRepository authRepo;
	
	public void addUserAuth(Authorities auth)
	{
		authRepo.save(auth);
	}
}
