package com.donald.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donald.pojos.User;
import com.donald.services.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user;
	private static UserServiceImpl usi = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() for login");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user = usi.loginUser(username, password);
		
		if (user == null) {
			//TODO failed login 
			response.sendRedirect("login.html");
		} else {
			// successful login
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			
			if (user.getAdminCheck() == true) {
				System.out.println("Admin Logged In");
				//if user is admin
				response.sendRedirect("admin_home.html");		
			} else {
				System.out.println(user.getUsername() + " Logged In");
				response.sendRedirect("user_home.html");
			}
		}
	}

}
