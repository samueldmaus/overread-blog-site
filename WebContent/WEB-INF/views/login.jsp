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
	<spring:url value="/resources/icons/md-lock.svg" var="lockSvg" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${loginCss}" rel="stylesheet" />
</head>
<body>
	<section class="login_main">
		<form action="./login" method="post">
			<h2 class="login_header">Login</h2>
			<div class="login_illustration">
				<svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg" fill="#3F6078">
					<path d="M376 186h-20v-40c0-55-45-100-100-100S156 91 156 146v40h-20c-22.002 0-40 17.998-40 40v200c0 22.002 17.998 40 40 40h240c22.002 0 40-17.998 40-40V226c0-22.002-17.998-40-40-40zM256 368c-22.002 0-40-17.998-40-40s17.998-40 40-40 40 17.998 40 40-17.998 40-40 40zm62.002-182H193.998v-40c0-34.004 28.003-62.002 62.002-62.002 34.004 0 62.002 27.998 62.002 62.002v40z"/>
					
				</svg>
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
			<p class="new_account">Don't have an account?</p>
			<p class="new_account">Click <a href="register">here</a> to create an account</p>
		</form>
	</section>
</body>
</html>