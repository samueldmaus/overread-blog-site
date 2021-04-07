package com.overread.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.overread.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>
{

	@Query(value="SELECT * FROM comment WHERE blog_id = :bId", nativeQuery=true)
	public List<Comment> getCommentsByBlogId(@Param("bId")Long blog_id);
	
	@Query(value="DELETE FROM blogs_comment WHERE Blog_id = :bId AND comments_id = :cId", nativeQuery=true)
	public void deleteBlogComment(@Param("bId")Long blog_id, @Param("cId")Long comment_id);
}
