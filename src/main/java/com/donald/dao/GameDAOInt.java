package com.donald.dao;

import java.util.List;

import com.donald.pojos.Game;

public interface GameDAOInt {

	public List<Game> getAllGames();
	
	public List<Game> getRecentFavoriteGames(int userId);
	
	public int insertNewGame(Game game);
	
	public int getIdFromTeamName(String teamName);
}
