package com.donald.pojos;

public class Game {

	private Integer gameId;
	private Integer team1Id;
	private Integer team2Id;
	private String team1Name;
	private String team2Name;
	private Integer team1Score;
	private Integer team2Score;
	private String winner;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(Integer gameId, Integer team1Id, Integer team2Id, String team1Name, String team2Name,
			Integer team1Score, Integer team2Score, String winner) {
		super();
		this.gameId = gameId;
		this.team1Id = team1Id;
		this.team2Id = team2Id;
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
		this.winner = winner;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(Integer team1Id) {
		this.team1Id = team1Id;
	}

	public Integer getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(Integer team2Id) {
		this.team2Id = team2Id;
	}

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public Integer getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(Integer team1Score) {
		this.team1Score = team1Score;
	}

	public Integer getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(Integer team2Score) {
		this.team2Score = team2Score;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		result = prime * result + ((team1Id == null) ? 0 : team1Id.hashCode());
		result = prime * result + ((team1Name == null) ? 0 : team1Name.hashCode());
		result = prime * result + ((team1Score == null) ? 0 : team1Score.hashCode());
		result = prime * result + ((team2Id == null) ? 0 : team2Id.hashCode());
		result = prime * result + ((team2Name == null) ? 0 : team2Name.hashCode());
		result = prime * result + ((team2Score == null) ? 0 : team2Score.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		if (team1Id == null) {
			if (other.team1Id != null)
				return false;
		} else if (!team1Id.equals(other.team1Id))
			return false;
		if (team1Name == null) {
			if (other.team1Name != null)
				return false;
		} else if (!team1Name.equals(other.team1Name))
			return false;
		if (team1Score == null) {
			if (other.team1Score != null)
				return false;
		} else if (!team1Score.equals(other.team1Score))
			return false;
		if (team2Id == null) {
			if (other.team2Id != null)
				return false;
		} else if (!team2Id.equals(other.team2Id))
			return false;
		if (team2Name == null) {
			if (other.team2Name != null)
				return false;
		} else if (!team2Name.equals(other.team2Name))
			return false;
		if (team2Score == null) {
			if (other.team2Score != null)
				return false;
		} else if (!team2Score.equals(other.team2Score))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", team1Id=" + team1Id + ", team2Id=" + team2Id + ", team1Name=" + team1Name
				+ ", team2Name=" + team2Name + ", team1Score=" + team1Score + ", team2Score=" + team2Score + ", winner="
				+ winner + "]";
	}

}
