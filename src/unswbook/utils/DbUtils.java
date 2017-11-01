package unswbook.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unswbook.beans.Student;
 
public class DbUtils {
 
 
    public static Student findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.username, a.password, a.gender, a.id, a.admin, a.firstname, a.lastname, a.email, a.unswid from student a "
                + " where a.username = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            int id = rs.getInt("Id");
            boolean admin = rs.getBoolean("Admin");
            String firstname = rs.getString("Firstname");
            String lastname = rs.getString("Lastname");
            String email = rs.getString("Email");
            String unswid = rs.getString("Unswid");
            Student user = new Student();
            user.setUsername(userName);
            user.setPassword(password);
            user.setGender(gender);
            user.setId(id);
            user.setAdmin(admin);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setUnswid(unswid);
            
            return user;
        }
        return null;
    }
 
    public static Student findUser(Connection conn, 
            String userName, String password) throws SQLException {
 
        String sql = "Select a.id, a.username, a.password, a.email, a.gender, a.ban, a.admin, a.verified from student a "
                + " where a.username = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("gender");
            int id = rs.getInt("Id");
        	String email = rs.getString("email");
        	boolean ban = rs.getBoolean("Ban");
        	boolean admin = rs.getBoolean("Admin");
        	boolean verified = rs.getBoolean("Verified");
            Student user = new Student();
            user.setUsername(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setGender(gender);
            user.setBanned(ban);
            user.setAdmin(admin);
            user.setId(id);
            user.setVerified(verified);
            
            return user;
        }
        return null;
    }
    
    public static ArrayList<Student> findgender(Connection conn, String Gender) throws SQLException {
     	
 	  // System.out.println( "++++++++++++++++gender++++++++++++++++++");
 	 
   String sql = "Select a.username, a.password, a.gender, a.id, a.admin, a.unswid,a.email,a.firstname,a.lastname ,a.dateOfBirth from student a "
           + " where a.gender= ? ";

   PreparedStatement pstm = conn.prepareStatement(sql);
   pstm.setString(1,Gender);

   ResultSet rs = pstm.executeQuery();
   ArrayList<Student> list = new ArrayList<Student>();

   while (rs.next()) {
   	
   	   // System.out.println( "++++++++++++++++next++++++++++++++++++");
       String password = rs.getString("Password");
       //String gender = rs.getString("Gender");
       int id = rs.getInt("Id");
       boolean admin = rs.getBoolean("Admin");
       String unswid = rs.getString("Unswid");
       String email = rs.getString("Email");
       String firstname = rs.getString("Firstname");
       String lastname = rs.getString("Lastname");
       String username = rs.getString("Username");
       
       Student user = new Student();
       user.setUsername(username);
       user.setPassword(password);
       user.setGender(Gender);
       user.setId(id);
       user.setAdmin(admin);
       user.setUnswid(unswid);
       user.setEmail(email);
       user.setFirstname(firstname);
       user.setLastname(lastname);
       
       list.add(user);
       //return user;
   }
   System.out.println( list.get(0).getUsername() + "and" + list.get(1).getUsername());
   return list;
 }
    
    public static Student findUserunswid(Connection conn, String userUnswid) throws SQLException {
    	
  	   System.out.println( "++++++++++++++++finduserunswid++++++++++++++++++");
  	 
      String sql = "Select a.username, a.password, a.gender, a.id, a.admin, a.unswid,a.email,a.firstname,a.lastname from student a "
              + " where a.unswid= ? ";

      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userUnswid);

      ResultSet rs = pstm.executeQuery();

      if (rs.next()) {
      	
      	   // System.out.println( "++++++++++++++++next++++++++++++++++++");
          String password = rs.getString("Password");
          String gender = rs.getString("Gender");
          int id = rs.getInt("Id");
          boolean admin = rs.getBoolean("Admin");
          //String unswid = rs.getString("Unswid");
          String email = rs.getString("Email");
          String firstname = rs.getString("Firstname");
          String lastname = rs.getString("Lastname");
          String username = rs.getString("Username");
          
          Student user = new Student();
          user.setUsername(username);
          user.setPassword(password);
          user.setGender(gender);
          user.setId(id);
          user.setAdmin(admin);
          user.setUnswid(userUnswid);
          user.setEmail(email);
          user.setFirstname(firstname);
          user.setLastname(lastname);
          
          return user;
      }
      //System.out.println( "++++++++++++++++null++++++++++++++++++");
      return null;
  }
    
    public static Student findemail(Connection conn, String Email) throws SQLException {
     	
 	 
     String sql = "Select a.username, a.password, a.gender, a.id, a.admin, a.unswid,a.email,a.firstname,a.lastname ,a.dateOfBirth from student a "
             + " where a.email= ? ";

     PreparedStatement pstm = conn.prepareStatement(sql);
     pstm.setString(1, Email);

     ResultSet rs = pstm.executeQuery();

     if (rs.next()) {
     	
     	   // System.out.println( "++++++++++++++++next++++++++++++++++++");
         String password = rs.getString("Password");
         String gender = rs.getString("Gender");
         int id = rs.getInt("Id");
         boolean admin = rs.getBoolean("Admin");
         String unswid = rs.getString("Unswid");
        // String email = rs.getString("Email");
         String firstname = rs.getString("Firstname");
         String lastname = rs.getString("Lastname");
         String username = rs.getString("Username");
         
         Student user = new Student();
         user.setUsername(username);
         user.setPassword(password);
         user.setGender(gender);
         user.setId(id);
         user.setAdmin(admin);
         user.setUnswid(unswid);
         user.setEmail(Email);
         user.setFirstname(firstname);
         user.setLastname(lastname);
         
         
         return user;
     }
     System.out.println( "++++++++++++++++null++++++++++++++++++");
     return null;
 }
    
    
}
