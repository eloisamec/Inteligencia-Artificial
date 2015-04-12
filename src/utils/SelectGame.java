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
		while (numPlayers < 3 || numPlayers > 5) {
			System.out.println("Numero de jogadores invalido! Digite um valor entre 3 e 5: ");
			numPlayers = in.nextInt();
		}
		
		System.out.println("Selecione o modo de jogo: 0 - Ultimo paga a conta; 1 - Primeiro ganha;");
		int mode = in.nextInt();
		while (mode < 0 && mode > 1) {
			System.out.println("Modo de jogo inválido! Selecione o modo de jogo: 0 - Ultimo paga a conta; 1 - Primeiro ganha;");
			mode = in.nextInt();
		}
		GameMode gameMode = mode == 0 ? GameMode.PagaConta : GameMode.PrimeiroGanha;
		
		System.out.println("OK! Jogaremos com " + numPlayers + " e modo de jogo " + gameMode);
		return new Settings(numPlayers, gameMode);
	}
}
