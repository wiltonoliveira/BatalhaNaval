package br.savior;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		inicio ();

	}
	
	public static void inicio () {
		int[][] tabuleiro1 = iniciaTabuleiro ();
		int[][] tabuleiro2 = iniciaTabuleiro ();
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
	
	public static void imprimirTabuleiro (int[][] tabuleiro) {
		for (int i = 0; i < 10; i++) {
			System.out.println("-----------------------------");
			for (int j = 0; j < 10; j++) {
				System.out.print("|" + tabuleiro[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	public static int[][] iniciaTabuleiro (){
		int[][] tabuleiro = new int [10][10];
		
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

	public static int[][] definirPosicao (int[][] tabuleiro){
		
		imprimirTabuleiro (tabuleiro);
		
		
		return tabuleiro;
	}

}
