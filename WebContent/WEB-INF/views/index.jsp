<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Homepage</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/images/restaurant.jpg" var="homePhoto" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="jumbotron jumbotron-fluid" style="background-image:url(${homePhoto }); background-size: cover" >
		<div class="overlay">
		</div>
		<div class="row">
			<div class="col-md-10 col-lg-8 mx-auto" style="color:#f5f5dc">
    			<div class="site-heading">
        			<h1>OverRead</h1>
        			<span class="subheading">By the curious, for the curious</span>
    			</div>
			</div>
		</div>
	</div>
	<sec:authorize access="isAuthenticated()">
    	Welcome to Overread, <sec:authentication property="name"/>
	</sec:authorize>
	<div class="container">
		<c:forEach items="${blogs}" var="blog">
			<div class="row">
				<div class="col-md-10 col-lg-8">
					<div class="post-preview">
						<h2><a href="./blog/${blog.getId() }">${blog.getTitle()}</a></h2>
						<p>${blog.getContents() }</p>
						<p class="post-meta">Posted by ${blog.getAuthor()} on ${blog.getDate().getMonth()+1}/${blog.getDate().getDate()}/${blog.getDate().getYear()+1900}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>