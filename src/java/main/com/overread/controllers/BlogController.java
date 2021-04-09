package com.overread.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.overread.models.Blog;
import com.overread.services.BlogService;

@Controller
public class BlogController
{
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/createBlog")
	public String getCreateBlog(Model model)
	{
		model.addAttribute("blog", new Blog());
		return "createblog";
	}
	
	@PostMapping("/createBlog")
	public String createBlogPost(@ModelAttribute("blog")Blog blog)
	{
		Date now = new Date();
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		blog.setAuthor(user.getUsername());
		blog.setDate(now);
		blogService.createBlog(blog);
		return "redirect:/";
	}
	
	@GetMapping("/blog/{blogId}/editBlog")
	public String getEditBlog(@PathVariable("blogId") long blogId, Model model)
	{
		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
		Blog blog = selectedBlog.get();
		blog.setContents();
		model.addAttribute("blog", blog);
		return "editblog";
	}
	
	@PostMapping("/blog/{blogId}/editBlog")
	public String updateBlog(@PathVariable("blogId")long blogId, @RequestParam("newTitle") String newTitle, @RequestParam("newContents")String newContents)
	{
		byte[] newContentsByte = newContents.getBytes();
		blogService.updateBlog(newTitle, newContentsByte, blogId);
		return "redirect:/blog/{blogId}";
	}
	
	@PostMapping("/blog/{blogId}/deleteBlog")
	public String deleteBlog(@PathVariable("blogId")Long blogId)
	{
		blogService.deleteBlog(blogId);
		return "redirect:/";
	}
	
	@GetMapping("/searchByTitle")
	public String getBlogsByTitle(@RequestParam("search")String searchTitle, Model model)
	{
		System.out.println(searchTitle);
		List<Blog> blogs = blogService.getBlogsByTitle(searchTitle);
		model.addAttribute("blogs", blogs);
		return "searchblogstitle";
	}
}
