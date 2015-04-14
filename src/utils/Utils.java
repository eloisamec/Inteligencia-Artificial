package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Utils {

	public static int randomHand(int round) {

		int hand = 0;
		double random = Math.random();
		if (random < 0.25)
			hand = 0;
		if (0.25 <= random & random < 0.5)
			hand = 1;
		if (0.5 <= random & random < 0.75)
			hand = 2;
		if (0.75 <= random & random < 1)
			hand = 3;
		
		return hand;
	}

	private static List<Integer> getPossibilities(int chopsticks, int othersChopsticks, List<Integer> guesses) {
		LinkedList<Integer> possibilities = new LinkedList<Integer>();
		for (int i = 0; i <= othersChopsticks; i++) {
			int tmp = chopsticks + i;
			boolean contains = false;
			int j = 0;
			while (!contains && j < guesses.size()) {
				if (tmp == ((Integer) guesses.get(j)).intValue())
					contains = true;
				j++;
			}
			if (!contains)
				possibilities.add(new Integer(tmp));
		}

		/*
		//print the list for tests!
			System.out.println("Chopsticks = "+ chopsticks +"; Others Chopsticks = "+ othersChopsticks +"Going to print the possibilities list:");
			for(int i = 0; i<possibilities.size(); i++)
				System.out.println("Elemento " + i+ "; valor = " + ((Integer) possibilities.get(i)) );
			System.out.println();
		//end of print list secion!
		 */
		
		return possibilities;
	}

	public static int generateGuess(int chopsticks, int maxMine, int everybodysChopsticks, List<Integer> guesses) {
		int othersChopsticks = everybodysChopsticks - maxMine;
		List<Integer> possibilities = getPossibilities(chopsticks, othersChopsticks, guesses);
		double standardDeviation = 0;
		double mean = 0;

		for (int i = 0; i < guesses.size(); i++)
			mean += ((int) guesses.get(i)) * 2;

		for (int i = 0; i < possibilities.size(); i++)
			mean += (int) possibilities.get(i);

		mean = mean / (guesses.size() * 2 + possibilities.size());
		// mean calculated!

		for (int i = 0; i < guesses.size(); i++)
			standardDeviation += Math.pow(
					(((Integer) guesses.get(i)).intValue() - mean) * 2, 2.0);

		for (int i = 0; i < possibilities.size(); i++)
			standardDeviation += Math.pow(
					((Integer) possibilities.get(i)).intValue() - mean, 2.0);

		standardDeviation = Math.pow(standardDeviation / (guesses.size() * 2 + possibilities.size() - 1.5), 0.5);
		// -1.5 for greater precision on estimation
		// standard deviation calculated!

		Random rand = new Random();

		double tempGuess = (rand.nextGaussian() * standardDeviation) + mean;

		int guess = ((Integer) possibilities.get(0)).intValue();
		double closestDiff = Math.abs(((Integer) possibilities.get(0)).intValue() - tempGuess);
		for (int i = 1; i < possibilities.size(); i++) {
			double tmp = Math.abs(((Integer) possibilities.get(i)).intValue() - tempGuess);
			if (tmp < closestDiff) {
				guess = ((Integer) possibilities.get(i)).intValue();
				closestDiff = tmp;
			}
		}
		return guess;
	}
}
