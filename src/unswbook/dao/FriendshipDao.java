package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import unswbook.beans.Student;

public class FriendshipDao extends BaseConn {
	public static FriendshipDao friendship;

	public static FriendshipDao getFriendship() {
		if (friendship == null) {
			friendship = new FriendshipDao();
		}
		return friendship;
	}
	
	public void updateFriendship (Student student1, Student student2) throws SQLException {
		Connection connection = getConnection();
		
		String sql = "INSERT INTO friends (friend1Id, friend2Id, applyTime, currentState) VALUES (?, ?, ?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, student1.getId());
		preparedStatement.setInt(2, student2.getId());
		DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		Date dateobj = new Date();
		preparedStatement.setString(3, df.format(dateobj));
		preparedStatement.setBoolean(4, false);
		

		preparedStatement.executeUpdate();
		connection.close();
		
	}
	
	public ArrayList<Integer> getFriends (int userId) throws SQLException {
		Connection connection = getConnection();
		
		ArrayList<Integer> friends = new ArrayList<Integer>();
		String sql = "SELECT friend1Id FROM friends WHERE friend2Id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int friend1Id = rs.getInt("Friend1Id");
			friends.add(friend1Id);
		}
		connection.close();
		return friends;
	}
	
	public ArrayList<String> getTime (int userId) throws SQLException {
		Connection connection = getConnection();
		
		ArrayList<String> time = new ArrayList<String>();
		String sql = "SELECT applyTime FROM friends WHERE friend2Id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String friend1Id = rs.getString("ApplyTime");
			time.add(friend1Id);
		}
		connection.close();
		return time;
	}

}
