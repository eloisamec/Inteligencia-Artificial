package utils;

public class Utils {
	
	public static int randomHand(int round) {
		
		int hand = 0;
		if (round == 1) {
			hand = (int) Math.random() * 3 + 1;
		} else {
			hand = (int) Math.random() * 3;
		}
		
		return hand;
	}

	public static int makeGuess(int chopsticks, int round, int myHand) {
		
		int guess = 0;
		if (round == 1) {
			guess = (int) Math.random() * chopsticks + 1; 
		} else {
			guess = (int) Math.random() * chopsticks;
		}
		return guess;
	}
}
