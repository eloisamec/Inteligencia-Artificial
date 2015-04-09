package conf;

public class Config {
	
	private int numPlayers;
	private boolean gameMode;
	private int round;
	
	public Config(int numPlayers, boolean gameMode){
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
