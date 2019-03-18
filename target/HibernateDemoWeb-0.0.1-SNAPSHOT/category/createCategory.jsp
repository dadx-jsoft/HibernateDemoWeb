<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Server Page</title>
</head>
<body>
	<%-- ${pageContext.request.contextPath} --%>
	<form action="${pageContext.request.contextPath}/category/create" method="POST">
	    <table>
            <tr>
                insert category:
                <input type="text" name ="nameCategory">
            </tr>
            <tr>
                <input type="submit" value="Ok">
            </tr>
        </table>

		

		
	</form>
</body>
</html>