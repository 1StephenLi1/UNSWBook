<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unswbook.dao.EntityDao, unswbook.beans.Post, unswbook.dao.StudentDao, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bullying report</title>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<% 
	ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
	StudentDao sd = new StudentDao();
	out.println("<div class='container'>");
	out.println("<h2>Bullying Words Report</h2>");
	out.println("<form action='/9321ass2/BullyDetecting'>");
	out.println("<select  class='selectpicker show-tick' name='showNumber' STYLE='position:absolute; TOP:140px; LEFT: 1050px;'>"
		+ "<option>choose a number...</option>"
			+ "<option value='1'>1</option>"
	+ "<option value='10'>10</option>"
		+ "<option value='100'>100</option>"
+ "</select>" 
	+ "<input type='submit' STYLE='position:absolute; TOP:95px; LEFT:1200px;' class='btn btn-primary'>"
				+ "</form>");
	
	out.println("<table class='table'>");
	out.println("<thead>"
		     +"<tr>"
		      +  "<th>User Name</th>"
		       +" <th>Content</th>"
		       + "<th>Email</th>"
		       + "<th>Time Posted</th>"
		      + "</tr>"
		   + "</thead>" + "<tbody>");
	int toShow = (int) request.getAttribute("toShow");
	if (toShow > posts.size()) {
		toShow = posts.size();
	}
	for (int i = 0; i < toShow; i++) {
		out.println("<tr>");
		out.println("<td>" + sd.getName(posts.get(i).getStudentId()) + "</td>");
		out.println("<td>" + posts.get(i).getContent() + "</td>");
		out.println("<td>" + sd.getEmail(posts.get(i).getStudentId()) + "</td>");
		out.println("<td>" + posts.get(i).getCreatedTime() + "</td>");
		out.println("</tr>");
	}
	out.println("</tbody>");
	out.println("</table>");
	out.println("</div>");
%>
</body>
</html>