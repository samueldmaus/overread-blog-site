package com.overread.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blogs")
public class Blog
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
}
