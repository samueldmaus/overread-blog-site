package com.overread.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overread.models.Blog;
import com.overread.repositories.BlogRepository;

@Service
@Transactional
public class BlogService
{
	@Autowired
	private BlogRepository blogRepo;
	
	public void createBlog(Blog blog)
	{
		blogRepo.save(blog);
	}
	
	public Optional<Blog> getBlog(long id)
	{
		return blogRepo.findById(id);
	}
	
	public Iterable<Blog> getAll()
	{
		return blogRepo.findAll();
	}
}
