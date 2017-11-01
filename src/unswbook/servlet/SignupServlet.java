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
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public SignupServlet() {
        super();
    }
 
    // Show signup page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/signup.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String unswid = request.getParameter("unswid");
        String action = request.getParameter("action");
        Student newUser = new Student();
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || firstname == null || lastname == null || email == null || dob == null || gender == null) {
            hasError = true;
            if(action!=null){
            	if(action.equals("activate")){
            		//check code == getServletContext().getParameter("activate_code")
            		//update database
            		//--> after_active.jsp
            	}
            }else{
	            errorString = "Please fill all blanks!";
	            System.out.println("Null happended");
        	}
        } else {
           // Connection conn = MyUtils.getStoredConnection(request);
            StudentDao sd = new StudentDao();
            newUser.setUsername(userName);
            newUser.setPassword(password);
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setEmail(email);
            newUser.setDateOfBirth(dob);
            newUser.setGender(gender);
            newUser.setUnswid(unswid);
            newUser.setAdmin(false);
            newUser.setBanned(false);
            newUser.setVerified(false);   
            
            SendEmail se = new SendEmail(email);
            String code = "aldfkjalkdfj";
            getServletContext().setAttribute("activate_code", code);
            se.sendConfirmationEmail(code);
            try {
				sd.updateStudent(newUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }

            
        
        // If error, forward to /login.jsp
        if (hasError) {
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/signup.jsp");
 
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
        	 System.out.println("Sign up successfully!");
        	 // TO DO !!!!!!!!!!!!!!!!!!
             response.sendRedirect(request.getContextPath() + "/waiting.jsp");
        }
    }
}