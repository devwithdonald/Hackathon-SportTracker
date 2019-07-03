package com.donald.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donald.pojos.Game;
import com.donald.pojos.User;
import com.donald.services.GameServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class viewRecentGames
 */
public class ViewRecentGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static GameServiceImpl gsi = new GameServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRecentGames() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		User user = (User) session.getAttribute("user");
		
		List<Game> favoriteGameList = gsi.viewRecentFavoriteGames(user.getUserId());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String favoriteGameListString = objectMapper.writeValueAsString(favoriteGameList);
		
		response.getWriter().write(favoriteGameListString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
