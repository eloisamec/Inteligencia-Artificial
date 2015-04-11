package conf;

import java.util.List;

import ai.Player;

public class Settings {
	
	private int numPlayers;
	private GameMode gameMode;
	private int round;
	private List<Player> winners;
	
	public List<Player> getWinners() {
		return winners;
	}

	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	public Settings(int numPlayers, GameMode gameMode){
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
	public GameMode getGameMode() {
		return gameMode;
	}
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
}
