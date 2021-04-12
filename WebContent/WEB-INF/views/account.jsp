<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<spring:url value="/resources/images/restaurant.jpg" var="homePhoto" />
	<spring:url value="/resources/images/blank-profile-picture.png" var="blankPic"/>
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
	<div class="container" >
	<div class="row">
		<div class="col">
			<c:choose>
				<c:when test="${picture == false }">
					<img style="border-radius: 50%; width:75%" src="${blankPic }" alt="blank" />
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<br/>
			<form style="text-align: center">
				<button style="margin-top: 25px">Edit Picture</button>
			</form>
		</div>
		<div class="col">
			<ul style="padding:15px">
				<li style="padding:10px">Username: ${loggedInUser.username }</li>
				<li style="padding:10px">Email: ${loggedInUser.email }</li>
			</ul>
		</div>
		</div>
	</div>
</body>
</html>