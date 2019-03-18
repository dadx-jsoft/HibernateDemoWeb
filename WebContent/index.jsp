<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Server Page</title>
</head>
<body>
	
	<%
		out.print("HelloWorld");
	%>
	</br>
	<a href="${pageContext.request.contextPath}/products" style = "text-decoration: none"> link to product </a> </br>
	<a href="${pageContext.request.contextPath}/product/create"> link to create product </a>
	
	
</body>
</html>