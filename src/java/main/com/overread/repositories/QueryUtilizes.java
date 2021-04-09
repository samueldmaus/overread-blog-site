package com.overread.repositories;

public class QueryUtilizes
{
	public String queryGetBlogsByTitle = "SELECT b FROM Blog b WHERE b.title LIKE LOWER(concat('%', concat(?1, '%')))";
	public String queryUpdateBlog = "UPDATE blogs SET title = :t, blogcontents = :bC WHERE id = :bId";

}
