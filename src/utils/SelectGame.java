package utils;

import java.util.Scanner;

import conf.GameMode;
import conf.Settings;

public class SelectGame {

	private static Scanner in;

	public static Settings selectGame() {
		
		in = new Scanner(System.in);
		System.out.println("Informe o numero de jogadores: ");
		int numPlayers = in.nextInt();
		while (numPlayers < 3 && numPlayers > 5) {
			System.out.println("Número de jogadores invalido! Digite um valor entre 3 e 5: ");
			numPlayers = in.nextInt();
		}
		
		System.out.println("Selecione o modo de jogo: 0 - Ultimo paga a conta; 1 - Primeiro ganha;");
		GameMode gameMode = in.nextInt() == 0 ? GameMode.PagaConta : GameMode.PrimeiroGanha;
		
		return new Settings(numPlayers, gameMode);
	}
}
