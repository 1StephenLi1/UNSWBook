<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
      <link rel="stylesheet" type="text/css" href="./css/index.css"/>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <jsp:include page="menu.jsp"></jsp:include>
            <h2 class="logtitle">Login Page</h2>
      <p style="color: red;">${errorString}</p>
 
 
 	  <%
 	  	  if(request.getAttribute("errorString")!=null){
 	  		  out.println("<p style='color:red'>"+request.getAttribute("errorString")+"</p>");
 	  	  }
 	  %>
      <form method="POST" action="${pageContext.request.contextPath}/login">
          <table class="logtable" border="0">
            <tr>
               <td>User Name</td>
               <td><input  class="loginborder" type="text" name="userName" value= "${user.userName}" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input class="loginborder" type="password" name="password" value= "${user.password}" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input  class="submit" type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
 
 
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>