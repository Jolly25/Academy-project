<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accesso</title>
<!-- Link a Bootstrap 5 CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/register.css type="text/css">
</head>
<body>
    <div class="register-container">
        <div class="gif-container">
            <!-- Inserisci qui la tua gif animata -->
            <img src=${pageContext.request.contextPath}/resources/style/globe-26.gif alt="GIF animata">
        </div>
        <h2 class="title">Benvenuto!</h2>
        <p>Compila tutti i campi per registrarti.</p>
        
        
     	<form:form method="POST" action="register"
		modelAttribute="registerForm">
            <div class="mb-3">
                <form:label path="username" for="email" class="form-label text-light">Email</form:label>
                <form:input path="username" type="text" class="form-control" id="email" placeholder="Inserisci la tua email" />
                <form:errors path="username" class="error"/>
            </div>
            <div class="mb-3">
                <form:label path="password" for="password" class="form-label text-light">Password</form:label>
                <form:input path="password" type="password" class="form-control" id="password" placeholder="Inserisci la tua password" />
                <form:errors path="password" class="error" />
            </div>
            <div class="mb-3">
                <form:label path="confirmPassword" for="confirmPassword" class="form-label text-light">Conferma password</form:label>
                <form:input path="confirmPassword" type="password" class="form-control" id="password" placeholder="Inserisci la tua password" />
                <form:errors path="confirmPassword" class="error"/>
            </div>
            <button type="submit" class="btn btn-primary btn-block login-button">Submit</button>
            <br>
            <p class="small-text"><a href="/AcademyFrontend/">Sei già registrato?</a></p>
		</form:form>
    </div>

    <!-- Link a Bootstrap 5 JS (Popper.js è necessario per Bootstrap 5) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha2/dist/js/bootstrap.min.js"></script>
</body>
</html>