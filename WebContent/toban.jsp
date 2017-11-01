<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ban a user</title>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>
</head>
<body>
	<br />
	<br />
	<form method="POST" action="${pageContext.request.contextPath}/toban">
		Search a user you wish to ban <input type="text" name="search">
		<input class="ban" type="submit" value= "ban">
	</form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>