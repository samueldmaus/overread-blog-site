<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Footer</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-lg-8 mx-auto">
					<p class="text-muted copyright">Copyright © Overread 2021</p>
				</div>
			</div>
		</div>
	</footer>

</body>
</html>