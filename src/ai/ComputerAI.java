package ai;

import utils.Utils;

public class ComputerAI extends HumanAI {

	public void setHand(int hand, int round) {
		hand = Utils.randomHand(round);
	}
}
