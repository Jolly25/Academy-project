<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<form:form method="POST" action="register"
		modelAttribute="registerForm">
		<div>
			<form:label path="username">Username</form:label>
			<form:input path="username"/>
			<form:errors path="username"/>
		</div>
		<div>
			<form:label path="password">Password</form:label>
			<form:password path="password"/>
			<form:errors path="password" class="error" />
			<br>
		</div>
		<div>
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:password path="confirmPassword"/>
			<form:errors path="confirmPassword"/>
			<br>
		</div>
		<button type="submit">Sign Up</button>
		<br>
	</form:form>

</body>
</html>