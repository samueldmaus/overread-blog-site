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
	
	public CommentService() {}
	
	public CommentService(CommentRepository commentRepo)
	{
		this.commentRepo = commentRepo;
	}
	
	public Comment addComment(Comment comment)
	{
		return commentRepo.save(comment);
	}
	
	public List<Comment> getCommentsForBlog(Long blog_id)
	{
		return commentRepo.getCommentsByBlogId(blog_id);
	}
	
	public void deleteComment(Long commentId)
	{
		commentRepo.deleteById(commentId);
	}
	
	public void updateComment( byte[] updatedComment, Long commentId)
	{
		commentRepo.updateBlogComment(updatedComment, commentId);
	}

}
