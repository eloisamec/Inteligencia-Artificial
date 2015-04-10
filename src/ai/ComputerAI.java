package ai;


public class ComputerAI extends Player {

	private int numChopsticksInGame;
	
	public ComputerAI(String name) {
		super(name);
	}

	public int getNumChopsticks() {
		return numChopsticksInGame;
	}

	public void setNumChopsticks(int numChopsticks) {
		this.numChopsticksInGame = numChopsticks;
	}
}
