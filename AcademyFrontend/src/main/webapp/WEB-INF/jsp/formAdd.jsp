<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form CheckString</title>
</head>
<body >

    <form:form method="POST" 
       action="add" modelAttribute="matchForm">
          <table>
             <tr>
                 <td><form:label path="input">Input</form:label></td>
                 <td><form:input path="input"/></td>
                 <td><form:errors path="input"/></td>
             </tr>
             <tr>
                 <td><input type="submit" value="Submit"/></td>
             </tr>
         </table>
     </form:form>

</body>
</html>
