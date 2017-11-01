<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ban a user</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/adminSearch">
		Search a user: <input type="text" name="search">
		<input type="submit" value= "search">
	</form>
</body>
</html>