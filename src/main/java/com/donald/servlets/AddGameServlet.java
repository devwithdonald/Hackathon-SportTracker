package com.donald.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donald.pojos.Game;
import com.donald.services.GameServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddGameServlet
 */
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static GameServiceImpl gsi = new GameServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("admin_home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String body = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Game game = om.readValue(body, Game.class);
		
		// if null not work
		game = gsi.insertNewGame(game);
		
		if (game == null) {
			response.getWriter().write("Failed to insert new game");
		} else {
			response.getWriter().write("succesfully inserted new game");
		}
		
	}

}
