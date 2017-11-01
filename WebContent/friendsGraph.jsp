<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unswbook.dao.EntityDao, unswbook.beans.Graph, unswbook.dao.GraphDao, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/vis.js"></script>
    <link href="./js.vis.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <style type="text/css">
       #mynetwork {
  width: 800px;
  height: 800px;
  border: 1px solid #444444;
  background-color: ;
}
    </style>
</head>
<body>
<div id="mynetwork">
	<div class="vis-network" tabindex="900" style="position: relative; overflow: hidden; touch-action: pan-y; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;"><canvas width="1200" height="800" style="position: relative; touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;"></canvas></div>
<%-- 	 <% EntityDao ed = new EntityDao();
    	String subject = ed.getSubject("Stephen");
    	
		out.println("var nodes = new vis.DataSet([");
		out.println("{id: 1, label:haha},{id: 2, label: 'Mike'}, {id:3, label:'Node 3'}, {id: 4, label: 'Node 4'}, {id: 5, label: 'Node5'}]);");
		out.println("var edges = new vis.DataSet([");
		out.println("{from: 1, to: 3}, {from: 1, to: 2}, {from: 2, to: 4}, {from: 2, to: 5} ]);");
		out.println("var container = document.getElementById('mynetwork');");
		out.println("var data = {nodes: nodes, edges: edges};");
		out.println("var option = {};");
		out.println("var network = new vis.Network(container, data, options);");
    %> --%>
</div>
       
     
<script type="text/javascript">
    // create an array with nodes
<%-- 
     var nodes = new vis.DataSet([
       <%
	        String subject = (String) request.getAttribute("subject");
	    	GraphDao gd = new GraphDao();
	    	EntityDao ed = new EntityDao();
	    	ArrayList<Graph> gList = gd.getComponent(subject);
	    	
        	for (int i = 0; i < gList.size(); i++) {
   		 		out.println("{id:" + 1 + "," + "label:" + "'" + ed.getObjectName(gList.get(i).getSubject()) + "'"  +"},");
   		 		System.out.println("My name : ++++++++" + ed.getObjectName(gList.get(i).getSubject()));	
   		 		out.println("{id:" + 2 + "," + "label:" + "' " + ed.getMessage(gList.get(i).getObject()) + "'" + "}");
   			}	 
   		
   		%>
      
    	
    ]);

    // create an array with edges
    var edges = new vis.DataSet([
      /*  {from: 1, to: 3},
        {from: 1, to: 2},
        {from: 2, to: 4},
        {from: 2, to: 5}  */
        {from: 1, to: 2},
        //{from: p1, to: p1}
        <%
        	//for (int j = 0; j < gList.size(); j++) {
        	//	out.println("{from:" + );
        	//}  
        %>
    ]);

    // create a network
    var container = document.getElementById('mynetwork');

    // provide the data in the vis format
    var data = {
        nodes: nodes,
        edges: edges
    };
    var options = {   
    	nodes: {
    	  label: "I'm a dot!",
    	  shape: 'dot',
    	  color: 'cyan'
    	}
    	
    };
    
    
    // initialize your network!
    var network = new vis.Network(container, data, options);  --%>
    
    var nodes = [
                 {id: 0, label: "0", group: 'source'},
                 {id: 1, label: "1", group: 'icons'},
                 {id: 2, label: "2", group: 'icons'},
                 {id: 3, label: "3", group: 'icons'},
                 {id: 4, label: "4", group: 'icons'},
                 {id: 5, label: "5", group: 'icons'},
                 {id: 6, label: "6", group: 'icons'},
                 {id: 7, label: "7", group: 'icons'},
                 {id: 8, label: "8", group: 'icons'},
                 {id: 9, label: "9", group: 'icons'},
                
                 {id: 15, group: 'dotsWithLabel'},
                 {id: 16, group: 'dotsWithLabel'},
                 {id: 17, group: 'dotsWithLabel'},
                 {id: 18, group: 'dotsWithLabel'},
                 {id: 19, group: 'dotsWithLabel'},
                 {id: 20, label: "Stephen", group: 'diamonds'},
                 {id: 21, label: "Mike", group: 'diamonds'},
                 {id: 22, label: "user", group: 'diamonds'},
                 {id: 23, label: "user", group: 'diamonds'},
               ];
               var edges = [
        			{from: 4, to: 20},
        			{from: 4, to: 21}
               ]

               // create a network
               var container = document.getElementById('mynetwork');
               var data = {
                 nodes: nodes,
                 edges: edges
               };
               var options = {
                 nodes: {
                   shape: 'dot',
                   size: 20,
                   font: {
                     size: 15,
                     color: 'black'
                   },
                   borderWidth: 2
                 },
                 edges: {
                   width: 2
                 },
                 groups: {
                   diamonds: {
                     color: {background:'red',border:'white'},
                     shape: 'diamond'
                   },
                   dotsWithLabel: {
                     label: "Hello world",
                     shape: 'dot',
                     color: 'cyan'
                   },
                   mints: {color:'rgb(0,255,140)'},
                   icons: {
                     shape: 'icon',
                     icon: {
                       face: 'FontAwesome',
                       code: '\uf0c0',
                       size: 50,
                       color: 'orange'
                     }
                   },
                   source: {
                     color:{border:'white'}
                   }
                 }
               };
               var network = new vis.Network(container, data, options);


 

</script>
</body>
</html>