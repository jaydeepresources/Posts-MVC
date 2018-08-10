<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Post</title>
</head>
<body>

	<h2>Delete Post Here</h2>

	<form action="/site/delete">
		<input type="text" name="id" placeholder="enter id">
		<input type="submit" value="delete">
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>