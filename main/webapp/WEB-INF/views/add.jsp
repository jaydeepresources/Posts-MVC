<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new post</title>
</head>
<body>

	<h1>Add a new Post</h1>

	<form:form method="post" action="addpost">
		<form:input path="title" placeholder="title"/>
		<form:input path="body" placeholder="body"/>
		<input type="submit" value="Add" />
	</form:form>

</body>
</html>