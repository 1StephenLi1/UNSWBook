package unswbook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unswbook.beans.Student;
import unswbook.dao.StudentDao;
import unswbook.dao.FriendshipDao;
import unswbook.utils.MyUtils;

/**
 * Servlet implementation class addFriendServlet
 */
@WebServlet("/addFriends")
public class addFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession();
	 
	        // Check User has logged on
	        Student loginedUser = MyUtils.getLoginedUser(session);
	 
	        // Not logged in
	        if (loginedUser == null) {
	            // Redirect to login page.
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }
	        // Store info to the request attribute before forwarding.
	        request.setAttribute("user", loginedUser);
	 
	        // If the user has logged in, then forward to the page
	        // /WEB-INF/views/userInfoView.jsp
	        RequestDispatcher dispatcher //
	                = this.getServletContext().getRequestDispatcher("/userProfile.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	HttpSession session = request.getSession();
	    	Student toAdd = (Student)session.getAttribute("toAdd");
	    	String email = toAdd.getEmail();
	    	SendEmail se = new SendEmail(email);
	    	String code = "fffffffff";
            getServletContext().setAttribute("activate_code", code);
            se.sendAcceptRequestEmail(code);
	    	 
		        // Check User has logged on
		    Student loginedUser = MyUtils.getLoginedUser(session);
		    FriendshipDao fd = new FriendshipDao();
		    try {
				fd.updateFriendship(toAdd, loginedUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("friendship request sent");
		    response.sendRedirect(request.getContextPath() + "/home.jsp");
	    	
	    }
}
