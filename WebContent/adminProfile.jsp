<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<head>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>administrator page</title>
<h1>This is for administrator only</h1>
</head>
<body>
	<b><a href="${pageContext.request.contextPath}/toban">Click here to ban a user</a></b>
	<br>
	<b><a href="${pageContext.request.contextPath}/adminSearch">Click here to search a user</a></b>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>