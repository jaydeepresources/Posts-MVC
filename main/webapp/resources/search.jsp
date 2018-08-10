<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search a Post</title>
</head>
<body>
<%
	if(request.getSession(false).getAttribute("loginStatus") == null)
		response.sendRedirect("http://localhost:8080/PostsCRUD/login.jsp");
%>
	<h2>Search Post Here</h2>

	<form action="ControllerServlet">
		<input type="text" name="id" placeholder="enter id"><br>
		<input type="submit" name="buttonName" value="search">
	</form>
	
	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>