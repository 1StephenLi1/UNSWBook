<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unswbook.beans.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="background:#000000; height: 55px; padding: 5px;">
  <div style="float: left">
  <head>

  </head>
     <h3 style="color:#FFFFFF">UNSWBook</h3>
  </div>
 
	<div style="float: right; padding: 10px; text-align: right; color:#FFFFFF;"> 
     <!-- User store in session with attribute: loginedUser -->
     <b>Hello <%
     			Student user = (Student)session.getAttribute("loginedUser");
     			if (user != null) {
     				out.println(user.getUsername());	
     			}
     			
     		%></b>
   <br/>
 
     <!-- User store in session with attribute: loginedUser -->
    
     <form method="POST" action="${pageContext.request.contextPath}/tosearch">
     <input type="text"
					class="form-control" id="Search" name="search"
					placeholder="Enter Search">
     <button type="submit" class="btn btn-primary" style="margin-top: 40px;">Search</button>
     </form>
 
 	
  </div>
 
</div>


