package com.overread.tests.services;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.overread.models.Blog;
import com.overread.models.Comment;
import com.overread.repositories.CommentRepository;
import com.overread.services.CommentService;

public class CommentServiceTests
{
	private static CommentService commentService;
	
	private static CommentRepository commentRepo;
	
	@BeforeClass
	public static void setup()
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
	
	@Test
	public void testGetCommentsForBlog()
	{
		byte[] b = null;
		Comment comment1 = new Comment("author", b, new Blog());
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment1);
		Mockito.when(commentRepo.getCommentsByBlogId(anyLong())).thenReturn(comments);
		List<Comment> actual = commentService.getCommentsForBlog((long)1);
		String expected = "author";
		assertEquals(expected, actual.get(0).getAuthor());
	}
	
	@Test
	public void testDeleteComment()
	{
		doNothing().when(commentRepo).deleteById(anyLong());
		commentService.deleteComment((long)1);
		verify(commentRepo, times(1)).deleteById((long) 1);
	}

}
