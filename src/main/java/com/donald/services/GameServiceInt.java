package com.donald.services;

import java.util.List;

import com.donald.pojos.Game;
import com.donald.pojos.User;

public interface GameServiceInt {
	
	public List<Game> viewAllGames();
	
	public List<Game> viewRecentFavoriteGames(int userId);
	
	public Game insertNewGame(Game game);

}
