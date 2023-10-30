<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Login</title>
</head>
<body >

    <form:form method="POST" 
       action="login" modelAttribute="loginForm">
          <table>
             <tr>
                 <td><form:label path="username">Username</form:label></td>
                 <td><form:input path="username"/></td>
                 <td><form:errors path="username"/></td>
             </tr>
             <tr>
                 <td><form:label path="password">Password</form:label></td>
                 <td><form:password path="password"/></td>
                 <td><form:errors path="password"/></td>
             </tr>
             <tr>
                 <td><form:label path="repeatPassword">Repeat password</form:label></td>
                 <td><form:password path="repeatPassword"/></td>
                 <td><form:errors path="repeatPassword"/></td>
             </tr>
             <tr>
                 <td><input type="submit" value="Submit"/></td>
             </tr>
         </table>
     </form:form>

</body>
</html>
