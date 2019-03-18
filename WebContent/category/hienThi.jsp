<%@page import="com.vn.entities.Category"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Server Page</title>
</head>
<body>
	Category name: <%= ((Category)request.getAttribute("categoryName")).getName() %> 
</body>
</html>