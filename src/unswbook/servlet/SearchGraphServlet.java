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

import unswbook.beans.Student;
import unswbook.utils.DbUtils;
import unswbook.utils.MyUtils;
import unswbook.dao.*;

/**
 * Servlet implementation class SearchGraphServlet
 */
@WebServlet("/SearchGraphServlet")
public class SearchGraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGraphServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/searchGraph.jsp");

		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String object = request.getParameter("object");//user name to be searched
		 String post = request.getParameter("post");
	        
	        boolean hasError = false;
	        String errorString = null;
	        String subject = null;
	        if (object != null) {
	            Connection conn = MyUtils.getStoredConnection(request);
	            if (conn == null) {
	            	System.out.println( "++++++++++++++++++++++++++++++++++");
	                System.out.println("Your database connection failed");
	                System.out.println( "++++++++++++++++++++++++++++++++++");

	            } else {
	                try {
				        // Find the user in the DB.
				        EntityDao ed = new EntityDao();
				        subject = ed.getSubject(object);
				        
				        if (subject == null) {
				            hasError = true;
				            errorString = "User Name is invalid";
				        }
				    } catch (SQLException e) {
				        e.printStackTrace();
				        hasError = true;
				        errorString = e.getMessage();
				    }
				}
	           }
	        if (post != null) {
	        	EntityDao ed = new EntityDao();
		        try {
					subject = ed.getSubject(post);
					System.out.println(subject  + "+++++++++");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
	        }
	        // If error, forward to /WEB-INF/views/login.jsp
	        if (hasError) {
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
	        	request.setAttribute("subject", subject);//send search result to result page by request attribute
	        	getServletConfig().getServletContext().getRequestDispatcher("/peopleGraph.jsp").forward(request, response);
	            
	        }
	    }
		
	}


