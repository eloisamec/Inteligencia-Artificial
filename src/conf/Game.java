package conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ai.ComputerAI;
import ai.HumanAI;
import ai.Player;


public class Game {

	public static void main(String[] args) {
		
		HumanAI human = new HumanAI();
		System.out.println("Informe o nome do jogador: ");
		Scanner in = new Scanner(System.in);
		
		Player player1 = new Player(in.nextLine());
		human.setPlayer(player1);
		
		System.out.println("Informe o número de jogadores: ");
		int numPlayers = in.nextInt();
		while (numPlayers < 3) {
			System.out.println("Número de jogadores inválido! Digite um valor entre 3 e 6: ");
			numPlayers = in.nextInt();
		}
		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		for (int i = 2; i <= numPlayers; i++) {
			Player player = new Player("player"+i);
			players.add(player);
		}
		
		Config config = new Config(numPlayers, true);
		
		for(Player p : players) {
			System.out.println(p.getName());
		}
		
		List<Integer> hands = new ArrayList<Integer>();
		System.out.println("Indique o número de chopsticks da sua mão: ");
		int hand = in.nextInt();
		while (hand <= 0 || hand > 3) {
			System.out.println("Valor escolhido inválido. Escolha entre 1 e 3");
			hand = in.nextInt();
		}
		hands.add(hand);
		ComputerAI pcai = new ComputerAI();
		
		for (int i = 2; i <= numPlayers; i++) {
			pcai.getHand(hand, config.getRound());
			hands.add(hand);
		}
		
		System.out.println();
		in.close();
	}

}
