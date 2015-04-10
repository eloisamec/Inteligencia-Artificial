package conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Utils;
import ai.ComputerAI;
import ai.Player;

public class Game {

	public static void main(String[] args) {
		
		System.out.println("Informe seu nome: ");
		Scanner in = new Scanner(System.in);
		
		Player human = new Player(in.nextLine());
		
		System.out.println("Informe o número de jogadores: ");
		int numPlayers = in.nextInt();
		while (numPlayers < 3 && numPlayers > 5) {
			System.out.println("Número de jogadores inválido! Digite um valor entre 3 e 5: ");
			numPlayers = in.nextInt();
		}
		
		System.out.println("Selecione o modo de jogo: 0 - Último paga a conta; 1 - Primeiro ganha;");
		boolean gameMode = in.nextInt() == 0 ? false : true;
		
		Settings settings = new Settings(numPlayers, gameMode);
		int numChopsticksInGame = 3 * numPlayers;

		System.out.println("Indique o número de chopsticks da sua mão: ");
		int hand = in.nextInt();
		while (hand <= 0 || hand > 3) {
			System.out.println("Valor escolhido inválido. Escolha entre 1 e 3");
			hand = in.nextInt();
		}
		human.setHand(hand);

		int sumHands = hand;
		
		List<Player> players = new ArrayList<Player>();
		players.add(human);
		for (int i = 2; i <= numPlayers; i++) {
			ComputerAI pc = new ComputerAI("player"+i);
			pc.setNumChopsticks(numChopsticksInGame);
			int myHand = Utils.randomHand(settings.getRound()); 
			pc.setHand(myHand);
			pc.setGuess(Utils.makeGuess(numChopsticksInGame, settings.getRound(), myHand));
			sumHands += myHand;
			players.add(pc);
		}
		
		String vencedor = "";
		int numVencedores = 0;
		for (Player p : players) {
			if (p.getGuess() == sumHands) {
				vencedor 
			}
		}
		in.close();
	}
}
