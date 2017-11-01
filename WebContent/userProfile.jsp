<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unswbook.beans.Student, java.util.ArrayList, unswbook.dao.PostDao, unswbook.dao.FriendshipDao, unswbook.dao.StudentDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css"/>
 </head>
 
 <body>
    <h3>Good day, ${user.username}</h3>
 	<br>
    User Name: <b>${user.username}</b>
    <br />
    
    Gender: <b>${user.gender}</b> <br />
   
    Email: <b>${user.email}</b> <br />
    
    My Friends: <b><% 
    					FriendshipDao fd = new FriendshipDao();
    					StudentDao sd = new StudentDao();
    					ArrayList<Integer> friends = new ArrayList<Integer>();
    					ArrayList<String> time = new ArrayList<String>();
    					Student user = (Student) request.getAttribute("user");
    					friends = fd.getFriends(user.getId());
    					time = fd.getTime(user.getId());
    					int k = 1;
    					out.println("<ul class='list-group'>");
 						for (int i = 0; i < friends.size(); i++) {
 							//out.println("Friend " + k + ":");
    						//out.println("<br/>");
    						
    						out.println("<li class='list-group-item'>");
    						out.println("Since:    " + time.get(i) + "    User Name:   " + sd.getName(friends.get(i)) +"</li>");
    						
    						k += 1;
 						}	
 						out.println("</ul>");
    				%></b> <br />
    
    My posts: <br /> <b><% 
    					ArrayList<String> posts = (ArrayList<String>) request.getAttribute("posts");
    					int j = 1;
    					PostDao pd = new PostDao();
    					out.println("<ul class='list-group'>");
    					for (int i = 0; i < posts.size(); i++) {
    						out.println("<li class='list-group-item'>");
    						out.println("Time:    " + pd.getPostTime(posts.get(i)));
    						out.println("      Content:    " + posts.get(i));
    						out.println("</li>");
    						j += 1;
    					}
    					out.println("</ul>");
    				%></b> <br /> 
 </body>

 <form method="POST" action="${pageContext.request.contextPath}/post">
 <textarea name="post"
   rows="5" cols="30">Share your thoughts here...</textarea>
     <button type="submit" class="btn btn-primary" style="margin-top: 25px;">Post</button>
 </form>
 <br />
 <a href="edit.jsp" type="submit" class="menu-box" style="margin-top: 25px;">Edit</a>
<jsp:include page="footer.jsp"></jsp:include>
</html>