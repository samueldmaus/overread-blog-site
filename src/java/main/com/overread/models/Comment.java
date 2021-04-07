package com.overread.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="AUTHOR", nullable=false)
	private String author;
	
	@Column(name="COMMENTCONTENTS", nullable=false)
	private byte[] commentContents;
	
	@Column(name="CONTENTS")
	private String contents;
	
	@ManyToOne
	private Blog blog;
	
	public Comment() {}
	
	public Comment(String author, byte[] contents, Blog blog)
	{
		this.author = author;
		this.commentContents = contents;
		this.blog = blog;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public byte[] getCommentContents()
	{
		return commentContents;
	}

	public void setCommentContents(byte[] commentContents)
	{
		this.commentContents = commentContents;
	}
	
	public String getContents()
	{
		return contents;
	}
	
	public void setContents()
	{
		contents = new String(commentContents);
	}
	
}
