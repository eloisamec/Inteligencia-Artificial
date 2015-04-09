package ai;

import utils.Utils;

public class ComputerAI extends HumanAI {

	public void getHand(int hand, int round) {
		hand = Utils.randomHand(round);
	}
}
