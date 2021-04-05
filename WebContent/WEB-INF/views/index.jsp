<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Homepage</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<h1>Home page</h1>
	<sec:authorize access="isAuthenticated()">
    	Welcome Back, <sec:authentication property="name"/>
	</sec:authorize>
	<a href="./logout"><Button>Logout</Button></a>
	<div class="container">
		<c:forEach items="${blogs}" var="blog">
			<div class="row">
				<div class="col-md-10 col-lg-8">
					<div class="post-preview">
						<h2><a href="#">${blog.getTitle()}</a></h2>
						<p>${blog.getContents() }</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>