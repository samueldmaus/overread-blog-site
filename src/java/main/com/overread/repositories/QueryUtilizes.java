package com.overread.repositories;

public class QueryUtilizes
{
	final String queryGetBlogsByTitle = "SELECT b FROM Blog b WHERE b.title LIKE LOWER(concat('%', concat(?1, '%')))";

}
