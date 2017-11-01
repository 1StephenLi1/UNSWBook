package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import unswbook.beans.Student;

public class AdminDao extends BaseConn {
	public static AdminDao admin;

	public static AdminDao getUser() {
		if (admin == null) {
			admin = new AdminDao();
		}
		return admin;
	}
	
	public void banStudent (Student student) throws SQLException {
		Connection connection = getConnection();
		String sql = "UPDATE student SET ban=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setBoolean(1, true);
		preparedStatement.setInt(2, student.getId());
		preparedStatement.executeUpdate();
		connection.close();
	}
	
	
}
