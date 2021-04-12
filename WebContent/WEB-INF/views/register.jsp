<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/css/register.css" var="registerCss" />
	<spring:url value="/resources/images/umbrella.jpg" var="umbrellaPic" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${registerCss}" rel="stylesheet" />
</head>
<body>
	<section class="register_main">
		<div class="form_container">
			<div class="image_holder">
				<img style="width:100%" src="${umbrellaPic}" alt="Seoul" />
			</div>
			<form:form action="./register" method="post" modelAttribute="user">
				<h2 class="account_text">Create an account:</h2>
				<div class="form-group">
					<form:input cssClass="form_input" path="username" placeholder="Username" />
					<form:errors path="username" />
				</div>
				<div class="form-group">
					<form:input cssClass="form_input" path="email" placeholder="Email" />
					<form:errors path="email" />
				</div>
				<div class="form-group">
					<form:input cssClass="form_input" type="password" path="password" placeholder="Password" />
					<form:errors path="password" />
				</div>
				<div class="form-group">
					<input class="form_input" type="password" name="confirmedPassword" placeholder="Confirm Password" />
				</div>
				<div>
					<button class="btn btn-primary btn-block" type="submit">Sign Up</button>
				</div>
				<p class="already_login">Already have an account? Click <a href="login">here</a> to login</p>
				<h5>${RegisterFailed }</h5>
			</form:form>
		</div>
	</section>
</body>
</html>