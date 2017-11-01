package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unswbook.beans.Student;

public class EntityDao extends BaseConn {
	public static EntityDao entity;
	
	public static EntityDao getEntity() {
		if (entity == null) {
			entity = new EntityDao();
		}
		return entity;
	}
	
	public String getSubject(String name) throws SQLException {
		Connection connection = getConnection();
		
		String sql = "SELECT subject FROM entityStore WHERE object = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet rs = preparedStatement.executeQuery();
		String subject = null;
		if (rs.next()) {
            subject = rs.getString("subject");
			connection.close();
			
		}
		return subject;
	}
	
	public String getObjectName(String subject) throws SQLException {
		Connection connection = getConnection();
		
		String sql = "SELECT object FROM entityStore WHERE subject = ? AND predicate='name'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, subject);
		ResultSet rs = preparedStatement.executeQuery();
		String object = null;
		if (rs.next()) {
            object = rs.getString("object");
			connection.close();
			
		}
		return object;
	}
	
	public String getObjectType(String subject) throws SQLException {
	Connection connection = getConnection();
		
		String sql = "SELECT object FROM entityStore WHERE subject = ? AND predicate='type'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, subject);
		ResultSet rs = preparedStatement.executeQuery();
		String object = null;
		if (rs.next()) {
            object = rs.getString("object");
			connection.close();
			
		}
		return object;
	}
	

	
	public String getMessage(String object) throws SQLException {
		Connection connection = getConnection();
		
		String sql = "SELECT object FROM entityStore WHERE subject = ? AND predicate='content'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, object);
		ResultSet rs = preparedStatement.executeQuery();
		String content = null;
		if (rs.next()) {
            content = rs.getString("object");
			connection.close();
			
		}
		return content;
	}
}
