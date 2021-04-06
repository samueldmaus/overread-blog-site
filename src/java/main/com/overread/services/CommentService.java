package com.overread.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.Comment;
import com.overread.repositories.CommentRepository;

@Service
@Transactional
public class CommentService
{
	@Autowired
	private CommentRepository commentRepo;
	
	public void addComment(Comment comment)
	{
		commentRepo.save(comment);
	}
	
	public void addBlogIdAndCommentId(Long blog_id, Long comment_id)
	{
		commentRepo.insertBlogIdCommentId(blog_id, comment_id);
	}
	
	public List<Comment> getCommentsForBlog(Long blog_id)
	{
		return commentRepo.fetchCommentsForBlog(blog_id);
	}
}
