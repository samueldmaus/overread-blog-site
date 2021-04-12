package com.overread.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.overread.models.User;

public interface UserRepository extends CrudRepository<User, String>
{
	public User findUserByUsername(String username);
	
	@Modifying
	@Query(value="UPDATE users SET profilepic = :p WHERE username = :u", nativeQuery=true)
	public void updateUserPicture(@Param("u")String username, @Param("p")byte[] p);
}
