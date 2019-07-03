package com.donald.services;

import java.util.List;

import com.donald.dao.GameDAOImpl;
import com.donald.pojos.Game;
import com.donald.pojos.User;

public class GameServiceImpl implements GameServiceInt{

	private static GameDAOImpl gdi = new GameDAOImpl();
	
	@Override
	public List<Game> viewAllGames() {
		// call DAO
		List<Game> gameList = null;
		
		gameList = gdi.getAllGames();
		
		return gameList;
	}

	@Override
	public List<Game> viewRecentFavoriteGames(int userId) {
		List<Game> favoriteGameList = null;
		
		favoriteGameList = gdi.getRecentFavoriteGames(userId);
		
		return favoriteGameList;
	}

	@Override
	public Game insertNewGame(Game game) {
		
		int successCode = gdi.insertNewGame(game);
		
		if (successCode == 1) {
			return game;
		} else {
			return null;
		}

	}

}
