package com.overread.services;

import java.util.List;

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
	
	public Iterable<Blog> get5MostRecent()
	{
		return blogRepo.findAll();
	}
}
