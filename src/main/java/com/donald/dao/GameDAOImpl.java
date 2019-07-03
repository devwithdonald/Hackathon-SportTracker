package com.donald.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.donald.pojos.Game;
import com.donald.util.ConnectionFactory;

public class GameDAOImpl implements GameDAOInt{
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public List<Game> getAllGames() {
		
		List<Game> gameList = new ArrayList<>();
		Game game;
		
		String sql = "select * from sporttracker_games;";
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				game = new Game();
				game.setGameId(rs.getInt("game_id"));
				game.setTeam1Id(rs.getInt("team_id_1"));
				game.setTeam2Id(rs.getInt("team_id_2"));
				game.setTeam1Name(rs.getString("team_name_1"));
				game.setTeam2Name(rs.getString("team_name_2"));
				game.setTeam1Score(rs.getInt("team_score_1"));
				game.setTeam2Score(rs.getInt("team_score_2"));
				game.setWinner(rs.getString("winner"));
				gameList.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gameList;
	}

	@Override
	public List<Game> getRecentFavoriteGames(int userId) {
		List<Game> favoriteGameList = new ArrayList<>();
		Game game;
		String sql = "select * from sporttracker_games g where g.team_id_1 in (select t.team_id from sporttracker_favorite_teams f inner join sporttracker_teams t on f.team_id = t.team_id where f.user_id = ?)\r\n" + 
				"    or g.team_id_2 in (select t.team_id from sporttracker_favorite_teams f inner join sporttracker_teams t on f.team_id = t.team_id where f.user_id = ?) order by g.game_id desc;";
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				game = new Game();
				game.setGameId(rs.getInt("game_id"));
				game.setTeam1Id(rs.getInt("team_id_1"));
				game.setTeam2Id(rs.getInt("team_id_2"));
				game.setTeam1Name(rs.getString("team_name_1"));
				game.setTeam2Name(rs.getString("team_name_2"));
				game.setTeam1Score(rs.getInt("team_score_1"));
				game.setTeam2Score(rs.getInt("team_score_2"));
				game.setWinner(rs.getString("winner"));
				favoriteGameList.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return favoriteGameList;
	}

	@Override
	public int insertNewGame(Game game) {
		
		
		String sql = "INSERT INTO sporttracker_games(team_id_1, team_id_2, team_name_1, team_name_2, team_score_1, team_score_2, winner)\r\n" + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement pstmt;
		int numberOfRows = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//need call
			pstmt.setInt(1, getIdFromTeamName(game.getTeam1Name()));
			pstmt.setInt(2, getIdFromTeamName(game.getTeam2Name()));
			pstmt.setString(3, game.getTeam1Name());
			pstmt.setString(4, game.getTeam2Name());
			pstmt.setInt(5, game.getTeam1Score());
			pstmt.setInt(6, game.getTeam2Score());
			pstmt.setString(7, game.getWinner());
		
			numberOfRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numberOfRows;
	}

	@Override
	public int getIdFromTeamName(String teamName) {
		int teamId = 0;
		
		String sql = "select team_id from sporttracker_teams where name = ?";
		
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				teamId = rs.getInt("team_id");
			}
			
		} catch (SQLException e) {
			
		}
		return teamId;
	}

}
