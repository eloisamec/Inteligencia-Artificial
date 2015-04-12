package conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.SelectGame;
import utils.Utils;
import ai.ComputerAI;
import ai.Player;

public class Game {

	public static void main(String[] args) {

		Settings settings = SelectGame.selectGame();

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int numPlayers = settings.getNumPlayers();
		int numChopsticksInGame = 3 * numPlayers;

		List<Player> players = new ArrayList<Player>();

		for (int i = 2; i <= numPlayers; i++) {
			System.out.println("Informe seu nome: ");
			Player human = new Player(in.nextLine());
			players.add(human);
		}
		
		ComputerAI pc = new ComputerAI("Computer AI");
		players.add(pc);
		pc.setNumChopsticks(numChopsticksInGame);

		List<Player> controll = new ArrayList<Player>();

		while (players.size() >= 2) {
			controll = players;
			int sumHands = 0;
			System.out.println("Vamos para a " + settings.getRound()+ "a rodada!" + " Palitos disponíveis: " + numChopsticksInGame);
			for (Player p : controll) {
				if (!(p instanceof ComputerAI)) {
					System.out.println("Vez do Jogador "+ p.getName() +", indique o numero de chopsticks da sua mao: ");
					int hand = in.nextInt();
					while (hand <= 0 || hand > p.getChopsticks()) {
						System.out.println("Valor escolhido invalido. Escolha entre um valor entre 1 e 3: ");
						hand = in.nextInt();
					}
					p.setHand(hand);
					sumHands += hand;
				} else {
					int randomHand = Utils.randomHand(settings.getRound());
					p.setHand(randomHand);
					sumHands += randomHand;
					System.out.println("Jogador "+ p.getName() +" tem "+ p.getHand()+" palitos na mão.");
				}
			}
			System.out.println("Hora dos palpites!");
			List<Integer> guesses = new ArrayList<Integer>();
			for (Player p : controll) {
				int guess = 0;
				if (!(p instanceof ComputerAI)) {
					System.out.println("Vez do Jogador "+ p.getName() +", faca seu palpite: ");
					guess = in.nextInt();
					p.setGuess(guess);
					while (guess < 0 || guess > numChopsticksInGame || guesses.contains(guess)) {
						System.out.println("Valor de palpite invalido. Valor do palpite deve ser entre 0 e "
										+ numChopsticksInGame + " e nao pode ser igual ao dos outros jogadores: ");
						guess = in.nextInt();
					}
				} else {
					guess = Utils.generateGuess(p.getChopsticks(), numChopsticksInGame, guesses);
					p.setGuess(guess);
				}
				System.out.println("Jogador " + p.getName()	+ " escolheu o valor " + guess);
				guesses.add(guess);
			}
			String vencedor = null;
			int position = 0;
			for (Player p : controll) {
				if (p.getGuess() == sumHands) { 
					vencedor = p.getName();
					System.out.println("Vencedor da rodada foi " + vencedor + " com o palpite " + sumHands);
					numChopsticksInGame--;
					p.setChopsticks(p.getChopsticks() - 1);
					if (p.getChopsticks() == 0 && settings.getGameMode() == GameMode.PrimeiroGanha) {
						System.out.println("Jogo acabou! Vencedor e: " + p.getName());
						return;
					} else {
						if (p.getChopsticks() == 0 && settings.getGameMode() == GameMode.PagaConta) {
							System.out.println(p.getName()
									+ " nao precisa pagar a conta! XD");
							controll.remove(p);
							if (controll.size() == 1) {
								System.out.println(controll.get(0).getName()
										+ " paga a conta hoje!");
								return;
							}
							break;
						}
					}
					position = controll.indexOf(p);
				}
			}
			if (vencedor == null) {
				System.out.println("Não tivemos vencedor na rodada! Numero de palitos total foi: "  + sumHands);
				players = new ArrayList<Player>();
				if(position+1 < controll.size()) {
					for (int i = position+1; i < controll.size(); i++) {
						players.add(controll.remove(i));
					}
					players.addAll(controll);
				} else {
					position = 0;
				}
			} else {
				players = new ArrayList<Player>();
				for (int i = position; i < controll.size(); i++) {
					players.add(controll.remove(i));
				}
				players.addAll(controll);
			}

			settings.setRound(settings.getRound() + 1);
		}
		in.close();
	}
}