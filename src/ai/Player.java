package ai;

public class Player {

	private String name;
	private int chopsticks;
	
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
