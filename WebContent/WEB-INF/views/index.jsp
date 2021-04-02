<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<h1>Home page</h1>
	<sec:authorize access="isAuthenticated()">
    	Welcome Back, <sec:authentication property="name"/>
	</sec:authorize>
	<a href="./logout"><Button>Logout</Button></a>
</body>
</html>