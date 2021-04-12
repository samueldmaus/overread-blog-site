package com.overread.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.overread.exceptions.PasswordLengthException;
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
		List<Blog> blogs = (List<Blog>) blogService.getAll();
		for(Blog b : blogs)
		{
			b.setContents();
		}
		Collections.reverse(blogs);
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
	public String processRegister(@ModelAttribute("user") User user) throws PasswordLengthException
	{
		if(user.getPassword().length() < 6)
		{
			throw new PasswordLengthException("Password must be at least 7 characters long");
		}
		Set<Authorities> userAuth = new HashSet();
		List<Authorities> authIt = (List<Authorities>) authService.getAllAuths();
		userAuth.add(authIt.get(0));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAuthorities(userAuth);
		userService.addUser(user);
		//authService.addAuthorityToUser(user);
		return "redirect:/login";
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
	
	@GetMapping("/account")
	public String getUserAccount(Model model) throws IOException
	{
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = userService.findUserByUsername(user.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
		if(loggedInUser.getProfile_pic() == null || loggedInUser.getProfile_pic().length == 0)
		{
			model.addAttribute("picture", false);
		}
		else
		{
			String base64Image = Base64.getEncoder().encodeToString(loggedInUser.getProfile_pic());
			model.addAttribute("prof_pic_user", base64Image);
		}
		return "account";
	}
	
	@PostMapping("/account/profilepic")
	public String openPicture(@RequestParam("file") CommonsMultipartFile file, HttpSession session)
	{
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = userService.findUserByUsername(user.getUsername());
		userService.updateUserPicture(loggedInUser.getUsername(), file.getBytes()); 
		return "redirect:/account";
	}
	
	@GetMapping("/about")
	public String getAboutMe()
	{
		return "about";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDenied()
	{
		return "denied";
	}
	
//	@PostMapping("/blog/{blogId}/postComment")
//	public String postComment(@PathVariable("blogId") long blogId, @ModelAttribute("comment") Comment comment)
//	{
//		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
//		Blog blog = selectedBlog.get();
//		Comment new_comment = new Comment(user.getUsername(), comment.getCommentContents(), blog);
//		commentService.addComment(new_comment);
//		return "redirect:/blog/{blogId}";
//	}
//	
//	@PostMapping("/blog/{blogId}/{commentId}/deleteComment")
//	public String deleteComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId)
//	{
//		commentService.deleteComment(commentId);
//		return "redirect:/blog/{blogId}";
//	}
//	
//	@GetMapping("/blog/{blogId}/{commentId}/editComment")
//	public String getEditComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId,  Model model, Model commentModel, Model blogComments, Model newComment)
//	{
//		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
//		Blog blog = selectedBlog.get();
//		model.addAttribute("blog", blog);
//		commentModel.addAttribute("comment", new Comment());
//		commentModel.addAttribute("username", user.getUsername());
//		commentModel.addAttribute("commentToEdit", commentId);
//		List<Comment> postedComments = commentService.getCommentsForBlog(blogId);
//		for(Comment c : postedComments)
//		{
//			c.setContents();
//		}
//		blogComments.addAttribute("blogComments", postedComments);
//		return "commentedit";
//	}
//	
//	@PostMapping("/blog/{blogId}/{commentId}/editComment")
//	public String postEditComment(@PathVariable("blogId") long blogId, @PathVariable("commentId") long commentId, @RequestParam("updatedComment") byte[] updatedComment)
//	{
//		commentService.updateComment(updatedComment, commentId);
//		return "redirect:/blog/{blogId}";
//	}
	
//	@GetMapping("/createBlog")
//	public String getCreateBlog(Model model)
//	{
//		model.addAttribute("blog", new Blog());
//		return "createblog";
//	}
//	
//	@PostMapping("/createBlog")
//	public String createBlogPost(@ModelAttribute("blog")Blog blog)
//	{
//		Date now = new Date();
//		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		blog.setAuthor(user.getUsername());
//		blog.setDate(now);
//		blogService.createBlog(blog);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/blog/{blogId}/editBlog")
//	public String getEditBlog(@PathVariable("blogId") long blogId, Model model)
//	{
//		Optional<Blog> selectedBlog = blogService.getBlog(blogId);
//		Blog blog = selectedBlog.get();
//		blog.setContents();
//		model.addAttribute("blog", blog);
//		return "editblog";
//	}
//	
//	@PostMapping("/blog/{blogId}/editBlog")
//	public String updateBlog(@PathVariable("blogId")long blogId, @RequestParam("newTitle") String newTitle, @RequestParam("newContents")String newContents)
//	{
//		byte[] newContentsByte = newContents.getBytes();
//		blogService.updateBlog(newTitle, newContentsByte, blogId);
//		return "redirect:/blog/{blogId}";
//	}
//	
//	@PostMapping("/blog/{blogId}/deleteBlog")
//	public String deleteBlog(@PathVariable("blogId")Long blogId)
//	{
//		blogService.deleteBlog(blogId);
//		return "redirect:/";
//	}
	
	/* will create authority levels in db
	@GetMapping("/createAuth")
	public String createAuthorities() {
		Authorities auth = new Authorities();
		auth.setAuthority("ROLE_USER");
		Authorities auth2 = new Authorities();
		auth2.setAuthority("ROLE_ADMIN");
		Authorities auth3 = new Authorities();
		auth3.setAuthority("ROLE_MOD");
		try
		{
			authService.addUserAuth(auth);
			authService.addUserAuth(auth2);
		}
		catch (Exception e)
		{
		
		}
		return "index";
	}
	*/
}
