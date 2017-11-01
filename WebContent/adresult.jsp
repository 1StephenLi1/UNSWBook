<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<%@ page import="unswbook.beans.Student, java.util.*"%>
<link rel="stylesheet" type="text/css" href="./css/index.css"/>

 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
    <h3>Advance Search Result</h3>
 	<br>

<%  
    ArrayList<Student> user_gender = (ArrayList<Student>)request.getAttribute("genderList");
 	Student result1 = (Student)request.getAttribute("searchResult");
 	if (user_gender != null){
 		int counter = 0;
 		for (int i = 0; i < user_gender.size(); i++) {
 		counter += 1;
 		out.println("<br>" + "----------------------------------------");
 		out.println("<br>" +"Candidate:" +  counter);
 		out.println("<br>" + "User Name:");
 		
 		out.println("<b>" + user_gender.get(i).getUsername() + "</b>");
 		out.println("<br>" + "UNSW ID:");
 		out.println("<b>" + user_gender.get(i).getUnswid() + "</b>");
 		out.println("<br>" + "Firstname:");
 		out.println("<b>" + user_gender.get(i).getFirstname() + "</b>");
 		out.println("<br>" + "Lastname:");
 		out.println("<b>" + user_gender.get(i).getLastname() + "</b>");
 		out.println("<br>" + "Gender:");
 		out.println("<b>" + user_gender.get(i).getGender() + "</b>");
 		out.println("<br>" + "Email:");
 		out.println("<b>" + user_gender.get(i).getEmail() + "</b>");
 		//out.println(user_gender.get(i).getUsername());
 		out.println("</br>");
 	}
 	}
 	else{
 		out.println("<br>" + "User Name:");
    
	out.println("<b>" + result1.getUsername() + "</b>");
	out.println("<br>" + "UNSW ID:");
	out.println("<b>" + result1.getUnswid() + "</b>");
	//out.println("</br>");
	out.println("<br>" + "Firstname:");
	out.println("<b>" + result1.getFirstname() + "</b>");
	out.println("<br>" + "Lastname:");
	out.println("<b>" + result1.getLastname() + "</b>");
	out.println("<br>" + "Gender:");
	out.println("<b>" + result1.getGender() + "</b>");
	out.println("<br>" + "Email:");
	out.println("<b>" + result1.getEmail() + "</b>");
	out.println("</br>");
	}

	//if (result == null) {
	//	out.println("you got nothing in result");
	//}
 	
%>

  
 
 </body>
<jsp:include page="footer.jsp"></jsp:include>
</html>