<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Blog</title>
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
        			<h1>Create Blog</h1>
    			</div>
			</div>
		</div>
	</div>
	<div class="container">
		<blockquote class="blockquote text-center">
			<h2>Create Blog</h2>
		</blockquote>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-lg-8 mx-auto">
				<form:form action="./createBlog" method="post" modelAttribute="blog">
					<form:input path="title" style="margin-bottom:15px" placeholder="Blog title..."/>
					<br/>
					<form:textarea path="blogContents" rows="25" class="form-control" placeholder="Blog text..."/>
					<br/>
					<button class="btn btn-primary btn-block" type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>