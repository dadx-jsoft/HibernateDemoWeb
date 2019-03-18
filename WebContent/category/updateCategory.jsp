<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Server Page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/category/update" method="POST">
	    <table>
            <tr>
                update category: </br>
                id: <input type="text" name="idCategory">  
                name:<input type="text" name ="nameCategory"> 
            </tr>
            <tr>
                <input type="submit" value="Ok">
            </tr>
        </table>
	</form>
</body>
</html>