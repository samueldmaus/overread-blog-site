<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="container" >
		<div class="row">
			<sec:authorize access="isAuthenticated()">
    			<sec:authentication property="name"/>
			</sec:authorize>
		</div>
		<div class="row">

		</div>
	</div>

</body>
</html>