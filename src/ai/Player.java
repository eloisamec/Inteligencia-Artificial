package ai;

public class Player {

	private String name;
	private int chopsticks;
	private int guess;
	private int hand;
	
	public int getGuess() {
		return this.guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public Player(String name) {
		this.name = name;
		this.chopsticks = 3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChopsticks() {
		return chopsticks;
	}

	public void setChopsticks(int chopsticks) {
		this.chopsticks = chopsticks;
	}
}
