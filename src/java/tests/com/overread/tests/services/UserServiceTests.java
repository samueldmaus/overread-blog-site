package com.overread.tests.services;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.overread.models.User;
import com.overread.repositories.UserRepository;
import com.overread.services.UserService;


public class UserServiceTests
{
	private static UserService userService;
	
	private static UserRepository userRepo;
	
	@BeforeAll
	public static void setup()
	{
		userRepo = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepo);
	}
	
	@Test
	public void testFindByUsername()
	{
		Mockito.when(userRepo.findUserByUsername(anyString())).thenReturn(new User("user1", "email1", "password1"));
		User actual = userService.findUserByUsername("user");
		String expected = "email1";
		assertEquals(expected, actual.getEmail());
	}

}
