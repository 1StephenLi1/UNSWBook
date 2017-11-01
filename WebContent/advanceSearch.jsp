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
 
      <h2 class="adsearch">Advance Search</h2>
      <p style="color: buld;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/toadresult">
         <table border="0">
         
        <!--   <input type="text"
					class="form-control" id="Search" name="search"
					placeholder="Enter Search"> -->
            	<div  class="adsearchtable" class="form-group col-sm-10">
			<label for="userName">User Name</label>
			 <input type="text" class="adsearchborder"
				class="form-control" id="userName" name="userName"
				placeholder="Enter userName">
		     </div>
		     <div class="adsearchtable" class="form-group col-sm-3">
			<label for="unswid">UNSW id</label>
			 <input  class="adsearchborder" type="text"
				class="form-control" id="unswid" name="unswid"
				placeholder="Enter unswid">
		     </div>
		    
		    <div class="adsearchtable" class="form-group col-sm-3">
			<label for="email">Email</label>
			 <input class="adsearchborder" type="text" 
				class="form-control" id="email" name="email"
				placeholder="Enter email">
		     </div>
		     <div class="adsearchtable" class="form-group col-sm-3">
			<label for="gender">Gender</label> 
			<input class="adsearchborder" type="text"
				class="form-control" id="gender" name="gender"
				placeholder="Enter gender">
		     </div>
		     
		     
		    <button type="submit" class="adsubmit" style="margin-top: 25px;">Search</button>
            
          <!--   <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr> -->
         </table>
      </form>
 
 
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>