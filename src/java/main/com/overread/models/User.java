package com.overread.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities = new HashSet<>();
	
	public User(){ this.enabled = true; };
	
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


}
