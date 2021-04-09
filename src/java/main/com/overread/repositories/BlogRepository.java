package com.overread.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.overread.models.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long>
{
	@Modifying
	@Query(value="UPDATE blogs SET title = :t, blogcontents = :bC WHERE id = :bId", nativeQuery=true)
	public void updateBlog(@Param("t")String title, @Param("bC")byte[] updatedBlogContents, @Param("bId")long blogId);
	
	@Query("SELECT b FROM Blog b WHERE b.title LIKE LOWER(concat('%', concat(?1, '%')))")
	public List<Blog> getBlogsByTitle(String search);
}
