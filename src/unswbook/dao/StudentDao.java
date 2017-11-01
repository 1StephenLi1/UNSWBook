package unswbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unswbook.beans.Graph;
import unswbook.beans.Student;


public class StudentDao extends BaseConn {
	public static StudentDao user;

	public static StudentDao getUser() {
		if (user == null) {
			user = new StudentDao();
		}
		return user;
	}

	public void updateStudent (Student student) throws SQLException {
		Connection connection = getConnection();
		
		if (student.getId() == 0) {
			String sql = "INSERT INTO student (username, password, firstname, lastname, email, dateOfBirth, ban, verified, unswid, gender, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getUsername());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getFirstname());
			preparedStatement.setString(4, student.getLastname());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getDateOfBirth());
			preparedStatement.setBoolean(7, student.isBanned());
			preparedStatement.setBoolean(8, student.isVerified());
			preparedStatement.setString(9, student.getUnswid());
			preparedStatement.setString(10, student.getGender());
			preparedStatement.setBoolean(11, student.isAdmin());

			preparedStatement.executeUpdate();
			connection.close();
		} else {
			String sql = "UPDATE student SET username=?, password=?, firstname=?, lastname=?, email=?, dateOfBirth=?, ban=?, verified=?, unswid=?, WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getUsername());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getFirstname());
			preparedStatement.setString(4, student.getLastname());
			preparedStatement.setString(5, student.getDateOfBirth());
			preparedStatement.setString(6, student.getEmail());
			preparedStatement.setString(7, student.getUnswid());
			preparedStatement.setBoolean(8, student.isBanned());
			preparedStatement.setBoolean(9, student.isVerified());

			preparedStatement.executeUpdate();
			connection.close();
		}
	}
	
	public Student getStudent(String username, String password) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM student WHERE username = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
                Student rsUser = toStudent(rs);
				connection.close();
				return rsUser;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
//	public ArrayList<Student> getStudents() throws SQLException {
//		Connection connection = getConnection();
//		String sql = "SELECT * FROM student";
//		ArrayList<Student> studentList = new ArrayList<Student>();
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//		ResultSet rs = preparedStatement.executeQuery();
//		while (rs.next()) {
//            Student s = toStudent(rs);
//			studentList.add(s);
//		}
//		connection.close();
//		
//
//		return studentList;
//	}
//	
	
	private Student toStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setUsername(rs.getString("username"));
		student.setPassword(rs.getString("password"));
		student.setFirstname(rs.getString("firstname"));
		student.setLastname(rs.getString("lastname"));
		student.setEmail(rs.getString("email"));
		student.setDateOfBirth(rs.getString("dateOfBirth"));
		student.setBanned(rs.getBoolean("banned"));
		student.setVerified(rs.getBoolean("verified"));
		student.setUnswid(rs.getString("unswid"));
		
		return student;
	}
	
	public String getName(int userId) throws SQLException {
		Connection connection = getConnection();
		String sql = "SELECT username FROM student WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		String name = null ;
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			name = rs.getString("username");
			connection.close();
		}
		return name;
		
	}
	
	public String getEmail(int userId) throws SQLException {
		Connection connection = getConnection();
		String sql = "SELECT email FROM student WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		String email = null ;
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			email = rs.getString("email");
			connection.close();
		}
		return email;	
	}
} 

