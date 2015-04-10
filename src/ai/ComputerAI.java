package ai;

import utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class ComputerAI extends HumanAI {

	public void getHand(int hand, int round) {
		hand = Utils.randomHand(round);
	}
	
	private List getPossibilities(int chopsticks, int othersChopsticks, List guesses){
		LinkedList<Integer> possibilities = new LinkedList<Integer>();
		for(int i=0; i<=othersChopsticks; i++){
			int tmp = chopsticks+i;
			boolean contains = false;
			int j = 0;
			while(!contains && j<guesses.size()){
				if(tmp==((Integer) guesses.get(j)).intValue()) contains = true;
				j++;
			}
			if(!contains) possibilities.add(new Integer(tmp));
		}
		return possibilities;
	}
	
	public void generateGuess(int chopsticks, int othersChopsticks, List guesses){
		List possibilities = getPossibilities(chopsticks, othersChopsticks, guesses);
		double standardDeviation = 0;
		double mean = 0;
		
		for(int i=0; i<guesses.size();i++)
			mean += ((int) guesses.get(i))*2;
		
		for(int i=0; i<possibilities.size();i++)
			mean += (int) possibilities.get(i);
		
		mean =  mean/(guesses.size()*2+possibilities.size());
		//mean calculated!
		
		for(int i=0; i<guesses.size();i++)
			standardDeviation += Math.pow( (  ((Integer) guesses.get(i)).intValue() - mean)*2, 2.0);
		
		for(int i=0; i<possibilities.size();i++)
			standardDeviation += Math.pow( ((Integer) possibilities.get(i)).intValue() - mean, 2.0);

		standardDeviation = Math.pow(standardDeviation/(guesses.size()*2 + possibilities.size() - 1.5), 0.5); 
			//-1.5 for greater precision on estimation
		//standard deviation calculated!
		
		Random rand = new Random();
		
		double tempGuess = (rand.nextGaussian()*standardDeviation) + mean;

		int guess = ((Integer) possibilities.get(0)).intValue();
		double closestDiff = Math.abs( ((Integer) possibilities.get(0)).intValue() - tempGuess);
		for (int i=1; i<possibilities.size(); i++) {
			double tmp = Math.abs( ((Integer) possibilities.get(i)).intValue() - tempGuess);
			if(tmp<closestDiff){
				guess = i;
				closestDiff = tmp;
			}
		}
		
		setGuess(guess);
	}
}
