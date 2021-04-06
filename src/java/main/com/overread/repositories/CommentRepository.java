package com.overread.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.overread.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>
{
	@Modifying
	@Query(value ="INSERT INTO blogs_comment VALUES(:bId, :cId)", nativeQuery = true)
	public void insertBlogIdCommentId(@Param("bId")Long blog_id, @Param("cId")Long comment_id);
	
	@Query(value="select * from comment join blogs_comment bc on comment.id = bc.comments_id WHERE bc.Blog_id = :bId", nativeQuery=true)
	List<Comment> fetchCommentsForBlog(@Param("bId")Long blog_id);
}
