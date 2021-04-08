package com.overread.tests.services;

import org.mockito.Mockito;
import static org.mockito.Mockito.anyLong;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.overread.models.Blog;
import com.overread.repositories.BlogRepository;
import com.overread.services.BlogService;

public class BlogServiceTests
{
	private static BlogService blogService;
	
	private static BlogRepository blogRepo;
	
	@BeforeAll
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

}
