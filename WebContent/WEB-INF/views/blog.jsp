<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<%@ include file="navbar.jsp" %>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-10 col-lg-8 mx-auto" style="color:#f5f5dc">
	    			<div class="site-heading">
	        			<h1>${blog.getTitle()}</h1>
	        			<span class="subheading">Posted by ${blog.getAuthor() } on ${blog.getDate().getMonth()+1}/${blog.getDate().getDay()}/${blog.getDate().getYear()+1900}</span>
	    			</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-lg-8">
					<p>${blog.setContents(); blog.getContents() }</p>
				</div>
			</div>
		</div>
</body>
</html>