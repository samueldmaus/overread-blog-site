package com.overread.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.overread.models.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long>
{
	
}
