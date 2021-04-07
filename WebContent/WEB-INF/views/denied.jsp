<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Access Denied</title>
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
	<div class="container">
		<div class="row">
			<h1>Sorry, you do not have access to this page</h1>
		</div>
	</div>
</body>
</html>