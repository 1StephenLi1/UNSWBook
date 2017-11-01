<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unswbook.dao.EntityDao, unswbook.beans.Graph, unswbook.dao.GraphDao, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>network</title>
<script type="text/javascript" src="./js/vis.js"></script>
    <link href="./js.vis.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <style type="text/css">
       #mynetwork {
  width: 100%;
  height: 800px;
  border: 1px solid #444444;
  background-color: ;
}
    </style>
</head>
<body>
<div id="mynetwork">
	<div class="vis-network" tabindex="900" style="position: relative; overflow: hidden; touch-action: pan-y; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;"><canvas width="1200" height="800" style="position: relative; touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;"></canvas></div>

</div>
       
     
<script type="text/javascript">
    // create an array with nodes

    var nodes = [
    <%
    String subject = (String) request.getAttribute("subject");
	GraphDao gd = new GraphDao();
	EntityDao ed = new EntityDao();
	ArrayList<Graph> gList = gd.getComponent(subject);
	ArrayList<String> nodes = new ArrayList<String>();
	for (int i = 0; i < gList.size(); i++) {
		if (nodes.contains("{id:" + "'"+ gList.get(i).getSubject() + "'" + "," + "label:" + "'" + ed.getObjectName(gList.get(i).getSubject()) + "'" + "," + "group:" + "'people'" +"},")) {
			if (ed.getObjectType(gList.get(i).getObject()).equalsIgnoreCase("message")) {
				nodes.add("{id:" + "'" + gList.get(i).getObject() + "'" + "," + "label:" + "' " + ed.getMessage(gList.get(i).getObject()) + "'" + "," + "group:" + "'message'" + "},");
			} else {
				nodes.add("{id:" + "'" + gList.get(i).getObject() + "'" + "," + "label:" + "' " + ed.getObjectName(gList.get(i).getObject()) + "'" + "," + "group:" + "'people'" + "},");
			}
			
		} else {
			if (ed.getObjectType(gList.get(i).getSubject()).equalsIgnoreCase("message")) {
				nodes.add("{id:" + "'"+ gList.get(i).getSubject() + "'" + "," + "label:" + "'" + ed.getMessage(gList.get(i).getSubject()) + "'" + "," + "group:" + "'message'" +"},");
			} else {
				nodes.add("{id:" + "'"+ gList.get(i).getSubject() + "'" + "," + "label:" + "'" + ed.getObjectName(gList.get(i).getSubject()) + "'" + "," + "group:" + "'people'" +"},");
			}
			System.out.println(gList.get(i).getSubject()+ "++++++++++++");
			if (ed.getObjectType(gList.get(i).getObject()).equalsIgnoreCase("message")) {
				nodes.add("{id:" + "'" + gList.get(i).getObject() + "'" + "," + "label:" + "' " + ed.getMessage(gList.get(i).getObject()) + "'" + "," + "group:" + "'message'" + "},");
			} else {
				nodes.add("{id:" + "'" + gList.get(i).getObject() + "'" + "," + "label:" + "' " + ed.getObjectName(gList.get(i).getObject()) + "'" + "," + "group:" + "'people'" + "},");
			}
		}		
	}	 
	for (int j = 0; j < nodes.size(); j++) {
		System.out.println(nodes.get(j));
		out.println(nodes.get(j));
	}
	%>
	]; 
    var edges = [
                 <%
                ArrayList<String> edges = new ArrayList<String>();
             	for (int i = 0; i < gList.size(); i++) {
             		edges.add("{from:" + "'" + gList.get(i).getSubject() + "'" + "," + "to:" + "'" + gList.get(i).getObject() + "'" + "},");
					//System.out.println("{from:" + "'" + gList.get(i).getSubject() + "'" + "," + "to:" + "'" + gList.get(i).getObject() + "'" + "},");
             	}	 
             	for (int j = 0; j < edges.size(); j++) {
             		System.out.println(edges.get(j));
             		out.println(edges.get(j));
             	}
             	%>   
                 
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
                width: 2,
                color: '#66ccff'
              },
              groups: {
                people: {
                  color: {background:'red',border:'white'},
                  shape: 'diamond'
                },
                message: {
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

    
/*   var string = "haha";
    var nodes = [
                 {id: 0, label: "0", group: 'source'},
                 {id: 1, label: "1", group: 'icons'},
                 {id: 'p1', label: "2", group: 'icons'},
                 {id: 'm1', label: "3", group: 'icons'},
                 {id: string, label: "4", group: 'icons'},
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
               ];  */
               

 

</script>
</body>
</html>