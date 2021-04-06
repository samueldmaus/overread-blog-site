<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navbar</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<div class="container">
    		<a class="navbar-brand" href="./">Overread</a>
    		<div class="collapse navbar-collapse" id="navbarResponsive">
    			<ul class="navbar-nav ml-auto">
        			<li class="nav-item"><a class="nav-link" href="./">Home</a></li>
        			<li class="nav-item"><a class="nav-link" href="./about">About Me</a></li>
        			<li class="nav-item"><a class="nav-link" href="#">Your Account</a></li>
        			<li class="nav-item"><a class="nav-link" href="./logout">Logout</a></li>
    			</ul>
    			<form class="d-flex">
        			<input class="form-control me-2" type="search" placeholder="Search By Title" aria-label="Search">
        			<button class="btn btn-outline-success" type="submit">Search</button>
      			</form>
			</div>
  		</div>
	</nav>
</body>
</html>