package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import unswbook.beans.Post;
import unswbook.beans.Student;

public class PostDao extends BaseConn {
	public static PostDao pd;

	public static PostDao getPost() {
		if (pd == null) {
			pd = new PostDao();
		}
		return pd;
	}
	
	public void updatePost (int userId, String contents) throws SQLException {
		Connection connection = getConnection();
		
		String sql = "INSERT INTO post (userId, content, createdTime) VALUES (?, ?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, contents);
		DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		Date dateobj = new Date();
		preparedStatement.setString(3, df.format(dateobj));
		

		preparedStatement.executeUpdate();
		connection.close();
		
	}
	
	public ArrayList<Post> getAllPosts () throws SQLException {
		Connection connection = getConnection();
		String sql = "SELECT * FROM post";
		ArrayList<Post> posts = new ArrayList<Post>();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Post post = new Post();
			post.setContent(rs.getString("Content"));
			post.setStudentId(rs.getInt("UserId"));
			post.setCreatedTime(rs.getTimestamp("CreatedTime"));
			posts.add(post);
		}
		
		return posts;

	}
	
	public ArrayList<String> getPosts (int userId) {
		Connection connection = getConnection();
		String sql = "SELECT content FROM post WHERE userId = ?";
		ArrayList<String> posts = new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
                String post = rs.getString("Content");
                posts.add(post);
				//connection.close();
				//return posts;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return posts;
	}
	
	public String getPostTime (String post) {
		Connection connection = getConnection();
		String sql = "SELECT createdTime FROM post WHERE content = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, post);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				
                String time = rs.getString("CreatedTime");
				connection.close();
				return time;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
}
