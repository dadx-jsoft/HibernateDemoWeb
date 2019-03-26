<%@page import="com.vn.entities.Category"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>add description</title>
</head>
<body>
Add description: </br>
	<form action="${pageContext.request.contextPath}/AddDescriptionProduct" method="POST">
		add Name: <input type="text" name ="nameProduct"> </br>
		add Price: <input type="text" name ="price"> </br>
		add Description: <input type="text" name ="description"> </br>
		add Content: <input type="text" name ="content"> </br>
		category: 
		<select name="idCategory" >
		<%
			List<Category> categories = (List<Category>) request.getAttribute("categoriesList");
			for(Category category : categories){
				out.println("<option value=" + category.getId() +">"+category.getName()+"</option>");
			}
		%>
		</select>
		<input type="submit" value="Ok"> </br>
	</form> 
	
</body>
</html>