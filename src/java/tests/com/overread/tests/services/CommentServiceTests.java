package com.overread.tests.services;

import static org.mockito.Mockito.anyObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.overread.models.Blog;
import com.overread.models.Comment;
import com.overread.repositories.CommentRepository;
import com.overread.services.CommentService;

public class CommentServiceTests
{
	private static CommentService commentService;
	
	private static CommentRepository commentRepo;
	
	@BeforeAll
	static void setup()
	{
		commentRepo = Mockito.mock(CommentRepository.class);
		commentService = new CommentService(commentRepo);
	}
	
	@Test
	public void testSaveComment()
	{
		byte[] b = null;
		Mockito.when(commentRepo.save(anyObject())).thenReturn(new Comment("author", b, new Blog()));
		Comment actual = commentService.addComment(new Comment());
		String expected = "author";
		assertEquals(expected, actual.getAuthor());
	}

}
