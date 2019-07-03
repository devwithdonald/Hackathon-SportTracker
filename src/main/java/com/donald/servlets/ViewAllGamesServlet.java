package com.donald.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donald.pojos.Game;
import com.donald.services.GameServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ViewAllGamesServlet
 */
public class ViewAllGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static GameServiceImpl gsi = new GameServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllGamesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get results for all sports games 
		
		List<Game> gameList = gsi.viewAllGames();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String gameListString = objectMapper.writeValueAsString(gameList);
		
		response.getWriter().write(gameListString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
