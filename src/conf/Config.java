package conf;

public class Config {
	
	private int numPlayers;
	private boolean gameMode;
	private static int rounds;
	
	public Config(int numPlayers, boolean gameMode){
		this.numPlayers = numPlayers;
		this.gameMode = gameMode;
		this.rounds = 1;
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

	public static int getRounds() {
		return rounds;
	}

	public static void setRounds(int rounds) {
		rounds = rounds;
	}
	
}
