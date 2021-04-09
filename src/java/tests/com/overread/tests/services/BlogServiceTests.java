package com.overread.tests.services;

import org.mockito.Mockito;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
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
	
	@Test
	public void testGetBlogsByTitle()
	{
		byte[] b = null;
		List<Blog> blogs = new ArrayList();
		blogs.add(new Blog(b, "title1", "author1"));
		blogs.add(new Blog(b, "title2", "author2"));
		Mockito.when(blogRepo.getBlogsByTitle(anyString())).thenReturn(blogs);
		List<Blog> actual = blogService.getBlogsByTitle("title");
		Blog expected = new Blog(b, "title2", "author2");
		assertEquals(expected, actual.get(1));
	}
	
	@Test
	public void testDeleteBlog()
	{
		doNothing().when(blogRepo).deleteById(anyLong());
		blogService.deleteBlog((long)1);
		verify(blogRepo, times(1)).deleteById((long)1);
	}
	
}
