package com.overread.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.overread.models.Authorities;
import com.overread.models.Blog;
import com.overread.models.Comment;
import com.overread.models.User;
import com.overread.services.AuthoritiesService;
import com.overread.services.BlogService;
import com.overread.services.CommentService;
import com.overread.services.UserService;

@Controller
public class MainController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesService authService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String getIndex(Model model)
	{
		Iterable<Blog> blogs = blogService.getAll();
		for(Blog b : blogs)
		{
			b.setContents();
		}
		model.addAttribute("blogs", blogs);
		return "index";
	}
	
	@GetMapping("/login")
	public String getHomeLogin()
	{
		/*
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object obj = auth.getPrincipal();
		User currentUser = (User)obj;
		System.out.println(currentUser.getUsername());
		*/
		return "login";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user") User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(user);
		// authService.addUserAuth(new Authorities(user, "USER"));
		return "redirect:/";
	}
	
	@GetMapping("/logoutSuccess")
	public String logoutSuccess()
	{

		return "login";
	}
	
	@GetMapping("/blog/{blogId}")
	public String getBlog(@PathVariable("blogId") long blogId, Model model, Model commentModel, Model blogComments)
	{
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
		Blog blog = selectedBlog.get();
		model.addAttribute("blog", blog);
		commentModel.addAttribute("comment", new Comment());
		commentModel.addAttribute("username", user.getUsername());
		List<Comment> postedComments = commentService.getCommentsForBlog(blogId);
		for(Comment c : postedComments)
		{
			c.setContents();
		}
		blogComments.addAttribute("blogComments", postedComments);
		return "blog";
	}
	
	@PostMapping("/blog/{blogId}/postComment")
	public String postComment(@PathVariable("blogId") long blogId, @ModelAttribute("comment") Comment comment)
	{
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
		Blog blog = selectedBlog.get();
		Comment new_comment = new Comment(user.getUsername(), comment.getCommentContents(), blog);
		commentService.addComment(new_comment);
		return "redirect:/blog/{blogId}";
	}
	
	@PostMapping("/blog/{blogId}/{commentId}/deleteComment")
	public String deleteComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId)
	{
		commentService.deleteComment(commentId);
		return "redirect:/blog/{blogId}";
	}
	
	@GetMapping("/blog/{blogId}/{commentId}/editComment")
	public String getEditComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId,  Model model, Model commentModel, Model blogComments, Model newComment)
	{
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
		Blog blog = selectedBlog.get();
		model.addAttribute("blog", blog);
		commentModel.addAttribute("comment", new Comment());
		commentModel.addAttribute("username", user.getUsername());
		commentModel.addAttribute("commentToEdit", commentId);
		List<Comment> postedComments = commentService.getCommentsForBlog(blogId);
		for(Comment c : postedComments)
		{
			c.setContents();
		}
		blogComments.addAttribute("blogComments", postedComments);
		return "commentedit";
	}
	
	@PostMapping("/blog/{blogId}/{commentId}/editComment")
	public String postEditComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId, @RequestParam("updatedComment") byte[] updatedComment)
	{
		commentService.updateComment(updatedComment, commentId);
		return "redirect:/blog/{blogId}";
	}
	
	@GetMapping("/account")
	public String getUserAccount()
	{
		return "account";
	}
}
