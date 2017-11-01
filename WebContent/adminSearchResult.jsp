<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unswbook.beans.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="./css/index.css"/>

 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
    <h3>Search Result</h3>
    
 	<br>
    User Name:
<%  
	Student result1 = (Student)request.getAttribute("searchResult");
	out.println("<b>" + result1.getUsername() + "</b>");
	out.println("<br>" + "Apply Time:");
	out.println("<b>" + result1.getApplyTime() + "</b>");
	//out.println("</br>");
	out.println("<br>" + "Start Time:");
	out.println("<b>" + result1.getFirstname() + "</b>");
	out.println("<br>" + "Last Name:");
	out.println("<b>" + result1.getLastname() + "</b>");
	out.println("<br>" + "Gender:");
	out.println("<b>" + result1.getGender() + "</b>");
	out.println("<br>" + "Email:");
	out.println("<b>" + result1.getEmail() + "</b>");
	out.println("</br>");
	//session.setAttribute("toAdd", result1);
%>




  
 
 </body>
<jsp:include page="footer.jsp"></jsp:include>
</html>