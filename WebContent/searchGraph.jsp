<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <link rel="stylesheet" type="text/css" href="./css/index.css"/>
  
   <head>
      <meta charset="UTF-8">
      <title>Advance Search</title>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <jsp:include page="menu.jsp"></jsp:include>
 
      <h2 class="adsearch">Search Graph</h2>
      <p style="color: buld;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/SearchGraphServlet">
            <div  class="adsearchtable" class="form-group col-sm-10">
			<label for="object">Search People</label>
			 <input type="text" class="adsearchborder"
				class="form-control" id="object" name="object"
				placeholder="search a username">
		     </div>
		    <button type="submit" class="adsubmit" style="position:absolute; TOP:182px; LEFT: 300px;">Search</button>
      </form>
 
 	      <form method="POST" action="${pageContext.request.contextPath}/SearchGraphServlet">
            <div  class="adsearchtable" class="form-group col-sm-10">
			<label for="post">Search Posts</label>
			 <input type="text" class="adsearchborder"
				class="form-control" id="object" name="post"
				placeholder="search a username">
		     </div>
		    <button type="submit" class="adsubmit" style="position:absolute; TOP:245px; LEFT: 300px;">Search</button>
      </form>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>