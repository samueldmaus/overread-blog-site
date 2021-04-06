package com.overread.services;

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
}
