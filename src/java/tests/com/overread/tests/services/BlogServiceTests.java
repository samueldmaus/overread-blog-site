package com.overread.tests.services;

import org.mockito.Mockito;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyObject;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.overread.models.Blog;
import com.overread.repositories.BlogRepository;
import com.overread.services.BlogService;

public class BlogServiceTests
{
	private static BlogService blogService;
	
	private static BlogRepository blogRepo;
	
	@BeforeClass
	public static void setup()
	{
		blogRepo = Mockito.mock(BlogRepository.class);
		blogService = new BlogService(blogRepo);
	}
	
	@Test
	public void testFindById()
	{
		byte[] b = null;
		Optional<Blog> returnBlog = Optional.ofNullable(new Blog(b, "title", "author"));
		Mockito.when(blogRepo.findById(anyLong())).thenReturn(returnBlog);
		Optional<Blog> actual = blogService.getBlog((long)1);
		String expected = "title";
		assertEquals(expected, actual.get().getTitle());
	}
	
	@Test
	public void testAddBlog()
	{
		byte[] b = null;
		Mockito.when(blogRepo.save(anyObject())).thenReturn(new Blog(b, "title", "author"));
		Blog actual = blogService.createBlog(new Blog());
		Blog expected = new Blog(b, "title", "author");
		assertEquals(expected, actual);
	}
	
	
}
