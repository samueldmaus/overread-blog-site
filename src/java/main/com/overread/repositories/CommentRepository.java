package com.overread.repositories;

import org.springframework.data.repository.CrudRepository;

import com.overread.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>
{

}
