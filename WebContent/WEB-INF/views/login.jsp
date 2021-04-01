<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overread Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="./login" method="post">
		<div>
			<label>Username: </label>
			<input type="text" name="username" />
		</div>
		<div>
			<label>Password: </label>
			<input type="text" name="password" />
		</div>
		<div>
			<button type="submit">Login</button>
		</div>
	</form>
	<h3>Don't have an account?</h3>
	<h3>Click <a href="register">here</a> to create an account</h3>
</body>
</html>