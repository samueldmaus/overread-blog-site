<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Overread Login</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/css/login.css" var="loginCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${loginCss}" rel="stylesheet" />
</head>
<body>
	<section class="login_main">
		<form action="./login" method="post">
			<h2 class="login_header">Login</h2>
			<div class="login_illustration">
				<i class="icon ion-ios-locked-outline"></i>
			</div>
			<div class="form-group">
				<input class="form_input" type="text" name="username" placeholder="Username" />
			</div>
			<div class="form-group">
				<input class="form_input" type="password" name="password" placeholder="Password" />
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">Log In</button>
			</div>
			<div>
				<p class="new_account">Don't have an account?</p>
				<p class="new_account">Click <a href="register">here</a> to create an account</p>
			</div>
		</form>
	</section>
</body>
</html>