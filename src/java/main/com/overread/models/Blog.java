package com.overread.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blogs")
public class Blog
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="BLOGCONTENTS", nullable=false)
	@Lob
	private byte[] blogContents;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="AUTHOR", nullable=false)
	private String author;
	
	@Column(name="DATECREATED", nullable=false)
	private Date date;
	
	@Column(name="CONTENTS")
	private String contents;
	
	@OneToMany
	private List<Comment> comments;
	
	public Blog(byte[] blog, String title, String author)
	{
		this.blogContents = blog;
		this.title = title;
		this.author = author;
		// this.date
		
	}
	
	public Blog() {}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public byte[] getBlogContents()
	{
		return blogContents;
	}

	public void setBlogContents(byte[] blogContents)
	{
		this.blogContents = blogContents;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public String getContents()
	{
		return contents;
	}
	
	public void setContents()
	{
		contents = new String(blogContents);
	}
	
	
}
