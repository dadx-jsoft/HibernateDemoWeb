<%@page import="com.vn.entities.Category"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Server Page</title>
</head>

<body>
	<%-- ${pageContext.request.contextPath} --%>
	<form action="${pageContext.request.contextPath}/product/create"
		method="POST">
		name: <input type="text" name="nameProduct"> 
		category: 
		
		<select name="idCategory" >
		
		<%
			List<Category> categories = (List<Category>) request.getAttribute("categoriesList");
			for(Category category : categories){
				out.println("<option value=" + category.getId() +">"+category.getName()+"</option>");
			}
		%>
		
		  
		</select>
		
		<input type="submit" value="Ok">
		
	</form>
	
	
</body>
</html>