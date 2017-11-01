package unswbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unswbook.beans.Student;
import unswbook.utils.DbUtils;
import unswbook.utils.MyUtils;
import unswbook.dao.*;

/**
 * Servlet implementation class ToAdvanceSearchServlet
 */
@WebServlet("/toadresult")
public class advanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advanceSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/advanceSearch.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("userName");//user name to be searched
        String unswid = request.getParameter("unswid");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        
        

        Student user_name = null;
        boolean hasError = false;
        String errorString = null;
        Student user_unswid = null;

        Student user_email = null;
        ArrayList<Student> user_gender = null;
        
        
        
        if (username != null || unswid != null || firstname != null || lastname != null || dateOfBirth != null || email != null || gender != null)
        {
        	    Connection conn = MyUtils.getStoredConnection(request);
            if (conn == null) {
            	System.out.println( "++++++++++++++++++++++++++++++++++");
                System.out.println("Your database connection failed");
                System.out.println( "++++++++++++++++++++++++++++++++++");

            } else {
                try {
                	
               
                	if(username != ""&& unswid != ""  && email != "" &&  gender != "")
                	{
                		
                		user_name = DbUtils.findUser(conn, username);
                		user_unswid = DbUtils.findUserunswid(conn, unswid);
                		user_email =  DbUtils.findemail(conn, email);
                		user_gender = DbUtils.findgender(conn, gender);
                	}
                	if(username != "" && unswid == ""  && email == "" &&  gender == "")
                	{
                		System.out.println( unswid );
                		System.out.println( "++++++++++++usename+++++++++++++++++++++");
                		user_name = DbUtils.findUser(conn, username);
                		//System.out.println(user_unswid);
                	}
                	
                	  if(unswid != ""  && email == "" &&  gender == "" && username == "")
                	{
                		System.out.println( unswid );
                		System.out.println( "++++++++++++unswid++++++++++++++++++++++");
                		user_unswid = DbUtils.findUserunswid(conn, unswid);
                		//System.out.println(user_unswid);
                	}
                	 if(email !="" &&  gender == "" && username =="" && unswid =="")
                	{
                		user_email =  DbUtils.findemail(conn, email);
                	}
                	 if(gender != "" && username == "" && unswid == "" && email == "")
                	{
                		user_gender = DbUtils.findgender(conn, gender);
                	}
                 if(gender != "" && username != "" && unswid == "" && email == "")
                 	{
                 		user_gender = DbUtils.findgender(conn, gender);
                 		user_name = DbUtils.findUserunswid(conn, username);
                 		
                 	}
                 if(gender != "" && username == "" && unswid != "" && email == "")
              	{
              		user_gender = DbUtils.findgender(conn, gender);
              		user_unswid = DbUtils.findUserunswid(conn, unswid);
              		
              	}
                 if(gender != "" && username == "" && unswid == "" && email != "")
              	{
              		user_gender = DbUtils.findgender(conn, gender);
              		user_email = DbUtils.findUserunswid(conn, email);
              		
              	}
                 if(gender == "" && username != "" && unswid != "" && email =="")
              	{
              		user_gender = DbUtils.findgender(conn, gender);
              		user_email = DbUtils.findUserunswid(conn, email);
              		
              	}
                 if(gender == "" && username != "" && unswid == "" && email != "")
              	{
              		user_gender = DbUtils.findgender(conn, gender);
              		user_unswid = DbUtils.findUserunswid(conn, unswid);
              		
              	}
                 if(gender == "" && username == "" && unswid != "" && email != "")
               	{
               		user_gender = DbUtils.findgender(conn, gender);
               		user_name = DbUtils.findUserunswid(conn, username);
               		
               	}
                 
                 if(gender != "" && username !=""&& unswid != "" && email == "")
              	{
              		user_gender = DbUtils.findgender(conn, gender);
              		user_name = DbUtils.findUserunswid(conn, username);
              		user_unswid = DbUtils.findUserunswid(conn, unswid);
              	}
                 if(gender != "" && username != "" && unswid == "" && email != "")
               	{
               		user_gender = DbUtils.findgender(conn, gender);
               		user_name = DbUtils.findUserunswid(conn, username);
               		user_email = DbUtils.findUserunswid(conn, email);
               	}
                 if(gender == "" && username != "" && unswid != "" && email != "")
               	{
               		user_gender = DbUtils.findgender(conn, gender);
               		user_name = DbUtils.findUserunswid(conn, username);
               		user_email = DbUtils.findUserunswid(conn, email);
               	}

                    if (user_name == null  && unswid == null && firstname == null && lastname == null && dateOfBirth == null && email == null && gender == null ) {
                    	System.out.println( "++++++++++++user is null ++++++++++++++++++++++");
                        hasError = true;
                        errorString = "User Name is invalid";
                    }
                } catch (SQLException e) {
                	
                		System.out.println( "++++++++++++cacth ++++++++++++++++++++++");
                    e.printStackTrace();
                    hasError = true;
                    
                    errorString = e.getMessage();
                }
            }

                        }
                    // If error, forward to /WEB-INF/views/login.jsp
                    if (hasError) {
                    	
                    	
                       System.out.println( "++++++++++++++++++1++++++++++++++++");
                      
             
                        // Store information in request attribute, before forward.
                        request.setAttribute("errorString", errorString);
             
                        // Forward to /login.jsp
                        RequestDispatcher dispatcher //
                                = this.getServletContext().getRequestDispatcher("/home.jsp");
             
                        dispatcher.forward(request, response);
                    }
                    // If no error
                    // Store user information in Session
                    // And redirect to userInfo page.
                    else {
                    	    System.out.println("++++++++++++++++else++++++++++++++++++");
                    	if (user_name != null ) {
                    		request.setAttribute("searchResult", user_name);//send search result to result page by request attribute
                   
                    		//tran data to jsp
                    		getServletConfig().getServletContext().getRequestDispatcher("/adresult.jsp").forward(request, response);
                    		getServletConfig().getServletContext().getRequestDispatcher("/adinfo.jsp").forward(request, response);
                        //response.sendRedirect(request.getContextPath() + "/search.jsp");
                    }
                    if(user_unswid != null)
                    	{
                     	System.out.println(user_unswid.getUnswid() + "++++++++++++++++++++id++++++++++++++");
                    		request.setAttribute("searchResult", user_unswid);//send search result to result page by request attribute
                    		
                    		//tran data to jsp
                    		getServletConfig().getServletContext().getRequestDispatcher("/adresult.jsp").forward(request, response);
                        //response.sendRedirect(request.getContextPath() + "/search.jsp");
                    		}
                       
                    	 if(user_email != null)
                    	{
                    		request.setAttribute("searchResult", user_email);//send search result to result page by request attribute
                    		//System.out.println(user_email.getEmail() + "++++++++++++++++6++++++++++++++++++");
                    		//tran data to jsp
                    		getServletConfig().getServletContext().getRequestDispatcher("/adresult.jsp").forward(request, response);
                        //response.sendRedirect(request.getContextPath() + "/search.jsp");
                    		}
                    	 if(user_gender != null)
                    	{
                    		//request.setAttribute("searchResult", user_gender);//send search result to result page by request attribute
                    		System.out.println("+++++++++++++++++7+++++++++++++++++");
                    		//tran data to jsp
                    		 System.out.println(user_gender.get(0).getUnswid());
                    		 System.out.println("+++++++++++++++++7+++++++++++++++++");
                    		request.setAttribute("genderList", user_gender);
                    		getServletConfig().getServletContext().getRequestDispatcher("/adresult.jsp").forward(request, response);
                        //response.sendRedirect(request.getContextPath() + "/search.jsp");
                    		}
                    	
                    	}
                    
                }
             
            }
                	
                
          
                	  
                	  
                	  
                	  

