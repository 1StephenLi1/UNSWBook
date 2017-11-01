<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="UTF-8">
      <title>edit</title>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <jsp:include page="menu.jsp"></jsp:include>
 
      <h3 class="logtitle">Edit Information</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/edit">
         <table class="logtable" border="0">
            <tr>
               <td>User Name</td>
               <td><input type="text" name="userName" value= "${user.userName}" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value= "${user.password}" /> </td>
            </tr>
            <tr>
            <tr>
            	<td>First Name</td>
            	<td><input type="text" name="firstname" value="${user.firstname}"/></td>
            </tr>
            <tr>
            	<td>Last Name</td>
            	<td><input type="text" name="lastname" value="${user.lastname}"/></td>
            </tr>
            <tr>
            	<td>Email</td>
            	<td><input type="text" name="email" value="${user.email}"/></td>
            </tr>
            <tr>
            	<td>Date of birth</td>
            	<td><input type="text" name="dob" value="${user.dob}"/></td>
            </tr>
            <tr>
            	<td>UNSW Id</td>
            	<td><input type="text" name="unswid" value="${user.unswid}"></td>
            </tr>
            <tr>
            	<td>Gender</td>
            	<td>
            		<select name="gender" value="${user.gender}">
            			<option value="none"></option>
            			<option value="female">Female</option>
  						<option value="male">Male</option>
					</select>
				</td>
            </tr>
            
               <td colspan ="2">
                  <input class="submit" type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
 
 
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
