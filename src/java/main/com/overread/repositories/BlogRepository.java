package com.overread.repositories;

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
}
