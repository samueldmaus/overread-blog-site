package com.overread.tests.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.anyObject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.overread.models.Authorities;
import com.overread.models.User;
import com.overread.repositories.AuthoritiesRepository;
import com.overread.services.AuthoritiesService;

import static org.junit.Assert.assertEquals;

public class AuthoritiesServiceTests
{
	private static AuthoritiesService authService;
	
	private static AuthoritiesRepository authRepo;
	
	@BeforeClass
	public static void setup()
	{
		authRepo = Mockito.mock(AuthoritiesRepository.class);
		authService = new AuthoritiesService(authRepo);
	}
	
	@Test
	public void testAddAuth()
	{
		Set<User> users = new HashSet();
		Mockito.when(authRepo.save(anyObject())).thenReturn(new Authorities("auth", users));
		Authorities actual = authService.addUserAuth(new Authorities());
		String expected = "auth";
		assertEquals(expected, actual.getAuthority());
	}
	
	@Test
	public void testGetAllAuth()
	{
		Set<User> users = new HashSet();
		List<Authorities> auths = new ArrayList();
		auths.add(new Authorities("admin", users));
		auths.add(new Authorities("user", users));
		Mockito.when(authRepo.findAll()).thenReturn(auths);
		List<Authorities> actual = (List<Authorities>) authService.getAllAuths();
		assertEquals("admin", actual.get(0).getAuthority());
	}

}
