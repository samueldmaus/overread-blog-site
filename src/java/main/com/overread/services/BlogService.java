package com.overread.services;

import java.util.List;
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
	
	public BlogService() {}
	
	public BlogService(BlogRepository blogRepo)
	{
		this.blogRepo = blogRepo;
	}
	
	public Blog createBlog(Blog blog)
	{
		return blogRepo.save(blog);
	}
	
	public Optional<Blog> getBlog(long id)
	{
		return blogRepo.findById(id);
	}
	
	public Iterable<Blog> getAll()
	{
		return blogRepo.findAll();
	}
	
	public List<Blog> getBlogsByTitle(String title)
	{
		return blogRepo.getBlogsByTitle(title);
	}
	
	public void updateBlog(String title, byte[] newBlogContents, long blogId)
	{
		blogRepo.updateBlog(title, newBlogContents, blogId);
	}
	
	public void deleteBlog(Long blogId)
	{
		blogRepo.deleteById(blogId);
	}
}
