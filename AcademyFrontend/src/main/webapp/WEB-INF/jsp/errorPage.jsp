<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/errorPage.css type="text/css">
</head>
<body>
	<div>
		<img src=${pageContext.request.contextPath}/resources/style/attention.svg>
		${message}
	</div>
</body>
</html>