package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unswbook.beans.Graph;
import unswbook.beans.Student;


public class GraphDao extends BaseConn {
	public static GraphDao graph;
	
	public static GraphDao getGraph() {
		if (graph == null) {
			graph = new GraphDao();
		}
		return graph;
	}
	
	public ArrayList<Graph> getComponent(String subject) throws SQLException {
		Connection connection = getConnection();
		String sql = "SELECT * FROM graph where subject=?";
		ArrayList<Graph> gList = new ArrayList<Graph>();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, subject);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
            Graph g = toGraph(rs);
			gList.add(g);
		}
		connection.close();
		

		return gList;
	}
	
	private Graph toGraph(ResultSet rs) throws SQLException {
		Graph graph = new Graph();
		graph.setObject(rs.getString("object"));
		graph.setPredicate(rs.getString("predicate"));
		graph.setSubject(rs.getString("subject"));
		
		return graph;
	}
	
}
