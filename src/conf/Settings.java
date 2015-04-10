package conf;

import java.util.List;

import ai.Player;

public class Settings {
	
	private int numPlayers;
	private boolean gameMode;
	private int round;
	private List<Player> winners;
	
	public List<Player> getWinners() {
		return winners;
	}

	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	public Settings(int numPlayers, boolean gameMode){
		this.numPlayers = numPlayers;
		this.gameMode = gameMode;
		this.round = 1;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	public boolean isGameMode() {
		return gameMode;
	}
	public void setGameMode(boolean gameMode) {
		this.gameMode = gameMode;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
}
