<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/login.css type="text/css">
<title>Form Login</title>

</head>
<body>


   <div class="login-container">
        <div class="gif-container">
            <img src=${pageContext.request.contextPath}/resources/style/globe-26.gif alt="GIF animata">
        </div>
        <h2 class="title">Accesso</h2>
    <form:form method="POST" 
       action="login" modelAttribute="loginForm">
            <div class="mb-3">
                <form:label path="username" for="username" class="form-label text-light">Username</form:label>
                <form:input path="username" type="text" class="form-control" id="username" placeholder="Inserisci il tuo username"/>
                <form:errors path="username" class="error"/>
            </div>
            <div class="mb-3">
                <form:label path="password" for="password" class="form-label text-light">Password</form:label>
                <form:input path="password" type="password" class="form-control" id="password" placeholder="Inserisci la tua password"/>
                <form:errors path="password" class="error"/>
                <br>
            </div>
            <button type="submit" class="btn btn-primary btn-block login-button">Login</button>
            <br>
            <p class="small-text"><a href="form_register">Non sei ancora registrato? Registrati</a></p>
        </form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha2/dist/js/bootstrap.min.js"></script>
</body>
</html>
