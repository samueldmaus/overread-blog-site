package com.overread.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User
{	
	@Id
	@Column(name="USERNAME")	
	private String username;

	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="ENABLED")
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "username"),
			inverseJoinColumns = @JoinColumn(name = "authorityId"))
	private Set<Authorities> authorities;
	
	@Lob
	@Column(name="PROFILEPIC")
	private byte[] profile_pic;
	
	public User()
	{
		this.enabled = true;
		this.authorities = new HashSet();
	}
	
	public User(String u, String e, String p)
	{
		this();
		this.username = u;
		this.email = e;
		this.password = p;
	}
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities)
	{
		this.authorities = authorities;
	}

	public byte[] getProfile_pic()
	{
		return profile_pic;
	}

	public void setProfile_pic(byte[] profile_pic)
	{
		this.profile_pic = profile_pic;
	}

	@Override
	public boolean equals(Object obj)
	{
		User compare = (User)obj;
		if(this.username.equals(compare.getUsername()) && this.email.equals(compare.getEmail()) && this.password.equals(compare.getPassword()))
		{
			return true;
		}
		return false;
	}
}
