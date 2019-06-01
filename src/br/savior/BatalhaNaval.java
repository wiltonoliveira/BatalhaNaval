package br.savior;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		inicio ();

	}
	
	public static void inicio () {
		char[][] tabuleiro1 = iniciaTabuleiro ();
		char[][] tabuleiro2 = iniciaTabuleiro ();
		int qtdJogadores = numJog ();
		
		
		if (qtdJogadores == 1) {
			tabuleiro1 = definirPosicao (tabuleiro1);
			//tabuleiro2 = preencherIA (tabuleiro2);
		}
		else {
			System.out.println("Tabuleiro 1");
			tabuleiro1 = definirPosicao (tabuleiro1);
			System.out.println("\n\nTabuleiro 2");
			tabuleiro2 = definirPosicao (tabuleiro2);
		}
		
	}
	
	public static void imprimirTabuleiro (char[][] tabuleiro) {
		
		System.out.print("    0   1   2   3   4   5   6   7   8   9\n");
		for (int i = 0; i < 10; i++) {
			System.out.println("  -----------------------------------------");
			System.out.print(i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print("|  " + tabuleiro[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("  -----------------------------------------");
	}
	
	public static char[][] iniciaTabuleiro (){
		char[][] tabuleiro = new char [10][10];
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
		return tabuleiro;
	}
	
	public static int numJog () {
		Scanner scan = new Scanner (System.in);
		System.out.print("Indique a quantidade de jogadores: ");
		
		
		int qtd = scan.nextInt();
		
		if (qtd > 2 || qtd < 1) {
			do {
				System.out.println("Quantidade de jogadores inválida. É permitido no máximo dois jogadores");
				qtd = scan.nextInt();
			}while (qtd < 1 || qtd > 2);
		}
		
		return qtd; 
	}

	public static char[][] definirPosicao (char[][] tabuleiro){
		
		imprimirTabuleiro (tabuleiro);
		
		System.out.println("DETERMINE A POSIÇÃO DO PORTA-AVIÕES (5 QUADRADOS)");
		
		return tabuleiro;
	}

}
