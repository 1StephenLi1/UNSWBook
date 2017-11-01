<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>post page</title>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
</head>
<body>

<h1>Post page</h1>


 <form method="POST" action="${pageContext.request.contextPath}/post">
 <div class="share">
 <textarea name="post"
   rows="10" cols="50">Share your thoughts here...</textarea>
     <button type="submit" class="btn btn-primary" style="margin-top: 25px;">Post a message</button>
 </div>
 </form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>