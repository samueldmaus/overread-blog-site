package com.overread.repositories;

import org.springframework.data.repository.CrudRepository;

import com.overread.models.User;

public interface UserRepository extends CrudRepository<User, Long>
{
	public User findUserByUsername(String username);
}
