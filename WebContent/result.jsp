<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<%@ page import="unswbook.beans.Student"%>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>


 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
    <h2 class="result">Search Result</h2>
    
    <div class="resulttable">
 	<br>
    User Name:
<%  
	Student result1 = (Student)request.getAttribute("searchResult");
	out.println("<b>" + result1.getUsername() + "</b>");
	out.println("<br>" + "UNSW ID:");
	out.println("<b>" + result1.getUnswid() + "</b>");
	//out.println("</br>");
	out.println("<br>" + "First Name:");
	out.println("<b>" + result1.getFirstname() + "</b>");
	out.println("<br>" + "Last Name:");
	out.println("<b>" + result1.getLastname() + "</b>");
	out.println("<br>" + "Gender:");
	out.println("<b>" + result1.getGender() + "</b>");
	out.println("<br>" + "Email:");
	out.println("<b>" + result1.getEmail() + "</b>");
	out.println("</br>");
	session.setAttribute("toAdd", result1);
%>

	<form method="POST" action="${pageContext.request.contextPath}/addFriends">
     <button type="submit" class="btn btn-primary" style="margin-top: 25px;">Add friend</button>
     </form>


  
 
 </body>
<jsp:include page="footer.jsp"></jsp:include>
</html>