package ai;

import utils.Utils;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class ComputerAI extends HumanAI {

	public void getHand(int hand, int round) {
		hand = Utils.randomHand(round);
	}
	
	private int generateGuess(int chopsticks, List possibilities, List guesses){
		double standardDeviation = 0;
		double mean = 0;
		
		for(int i=0; i<guesses.size();i++)
			mean += ((int) guesses.get(i))*2;
		
		for(int i=0; i<possibilities.size();i++)
			mean += (int) possibilities.get(i);
		
		mean =  mean/(guesses.size()*2+possibilities.size());
		//mean calculated!
		
		for(int i=0; i<guesses.size();i++)
			standardDeviation += Math.pow( (((int) guesses.get(i)) - mean)*2, 2.0);
		
		for(int i=0; i<possibilities.size();i++)
			standardDeviation += Math.pow( ((int) possibilities.get(i)) - mean, 2.0);

		standardDeviation = Math.pow( standardDeviation/(guesses.size()*2 + possibilities.size() - 1.5), 0.5); 
			//-1.5 for greater precision on estimation
		//standard deviation calculated!
		
		Random rand = new Random();
		
		double tempGuess = (rand.nextGaussian()*standardDeviation) + mean;

		int guess = 0;
		double closestDiff = Math.abs(((int) possibilities.get(0)) - tempGuess);
		for (int i=1; i<possibilities.size(); i++) {
			double tmp = Math.abs(((int) possibilities.get(i)) - tempGuess);
			if(tmp<closestDiff){
				guess = i;
				closestDiff = tmp;
			}
		}
		
		return guess; //temporary
	}
}
