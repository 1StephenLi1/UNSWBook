package unswbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
 * Servlet implementation class ToSearchServlet
 */
@WebServlet("/tosearch")
public class ToSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/header.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String toSearch = request.getParameter("search");//user name to be searched

        Student user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (toSearch == null) {
            hasError = true;
            errorString = "Required a username!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            if (conn == null) {
            	System.out.println( "++++++++++++++++++++++++++++++++++");
                System.out.println("Your database connection failed");
                System.out.println( "++++++++++++++++++++++++++++++++++");

            } else {
                try {
        // Find the user in the DB.
        user = DbUtils.findUser(conn, toSearch);

        if (user == null) {
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
        	request.setAttribute("searchResult", user);//send search result to result page by request attribute
        	getServletConfig().getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
            
        }
    }
 
}


