package com.overread.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITIES")
public class Authorities
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorityId;
	
	@Column(name="AUTHORITY")
	private String authority;
	
	@ManyToMany(mappedBy = "authorities")
	private Set<User> userList;

	public Authorities() {}
	
	public Authorities(String authority, Set<User> users)
	{
		this.authority = authority;
		this.userList = users;
	}
	
	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	public Integer getAuthorityId()
	{
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId)
	{
		this.authorityId = authorityId;
	}

	public Set<User> getUserList()
	{
		return userList;
	}

	public void setUserList(Set<User> userList)
	{
		this.userList = userList;
	}

}
