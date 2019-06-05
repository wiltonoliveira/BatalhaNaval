package br.savior;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		inicio ();

	}
	
	public static void inicio () {
		char[][] tabuleiro1 = iniciaTabuleiro ();
		char[][] tabuleiro2 = iniciaTabuleiro ();
		char[][] telaJ1 = iniciaTabuleiro ();
		char[][] telaJ2 = iniciaTabuleiro ();
		int win = 0;
		
		
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
			
			do {
				
				
				System.out.println("\n\n\n\n\n\nVez do Jogador 1");
				imprimirTabuleiro (telaJ1);
				telaJ1 = disparo(tabuleiro2, telaJ1);	
					
					
				System.out.println("\n\n\n\n\n\nVez do Jogador 2");
				imprimirTabuleiro (telaJ2);
				telaJ2 = disparo(tabuleiro1, telaJ2);
			} while (win == 0);
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
		tabuleiro = portaAviao (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		
		tabuleiro = navioTanque (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = navioTanque (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		
		tabuleiro = contraTorpeideiro (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = contraTorpeideiro (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = contraTorpeideiro (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		
		tabuleiro = submarino (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = submarino (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = submarino (tabuleiro);
		imprimirTabuleiro (tabuleiro);
		tabuleiro = submarino (tabuleiro);
		imprimirTabuleiro (tabuleiro);
			
		imprimirTabuleiro (tabuleiro);
		return tabuleiro;
		
	}
	
	public static char[][] posicionar (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'X';
		return tabuleiro;
	}
	
	public static char[][] portaAviao (char[][]tabuleiro){
		Scanner scan = new Scanner (System.in);
		
		System.out.println("DETERMINE A POSIÇÃO DO PORTA-AVIÕES (5 QUADRADOS)");
		System.out.print("LINHA DA POSIÇÃO INICIAL: ");
		
		int lin = scan.nextInt();
		
		System.out.print("COLUNA DA POSIÇÃO INICIAL: ");
		int col = scan.nextInt();
		
		System.out.print("1 - HORIZONTAL ou 2 - VERTICAL: ");
		int orientacao = scan.nextInt();
		//while (validarPosicao (tabela, lin, col) == 0);
		
		if (orientacao == 1) {
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		else {
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char[][] navioTanque (char[][] tabuleiro){
		Scanner scan = new Scanner (System.in);
		
		System.out.println("DETERMINE A POSIÇÃO DO NAVIO TANQUES (4 QUADRADOS)");
		System.out.print("LINHA DA POSIÇÃO INICIAL: ");
		
		int lin = scan.nextInt();
		
		System.out.print("COLUNA DA POSIÇÃO INICIAL: ");
		int col = scan.nextInt();
		
		System.out.print("1 - HORIZONTAL ou 2 - VERTICAL: ");
		int orientacao = scan.nextInt();
		//while (validarPosicao (tabela, lin, col) == 0);
		
		if (orientacao == 1) {
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		else {
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char[][] contraTorpeideiro (char[][] tabuleiro){
		Scanner scan = new Scanner (System.in);
		
		System.out.println("DETERMINE A POSIÇÃO DO CONTRATORPEIDEIROS (3 QUADRADOS)");
		System.out.print("LINHA DA POSIÇÃO INICIAL: ");
		
		int lin = scan.nextInt();
		
		System.out.print("COLUNA DA POSIÇÃO INICIAL: ");
		int col = scan.nextInt();
		
		System.out.print("1 - HORIZONTAL ou 2 - VERTICAL: ");
		int orientacao = scan.nextInt();
		//while (validarPosicao (tabela, lin, col) == 0);
		
		if (orientacao == 1) {
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		else {
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char[][] submarino (char[][] tabuleiro){
		Scanner scan = new Scanner (System.in);
		
		System.out.println("DETERMINE A POSIÇÃO DO SUBMARINO (2 QUADRADOS)");
		System.out.print("LINHA DA POSIÇÃO INICIAL: ");
		
		int lin = scan.nextInt();
		
		System.out.print("COLUNA DA POSIÇÃO INICIAL: ");
		int col = scan.nextInt();
		
		System.out.print("1 - HORIZONTAL ou 2 - VERTICAL: ");
		int orientacao = scan.nextInt();
		//while (validarPosicao (tabela, lin, col) == 0);
		
		if (orientacao == 1) {
			tabuleiro = posicionar (tabuleiro, lin, col);
			col += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
			
		}
		
		else {
			tabuleiro = posicionar (tabuleiro, lin, col);
			lin += 1;
			tabuleiro = posicionar (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char[][] disparo (char[][] tabuleiro, char[][] tela) {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Digite a linha do alvo: ");
		int linAlvo = scan.nextInt();
		
		System.out.println("Digite a coluna do alvo: ");
		int colAlvo = scan.nextInt();
		
		if (tabuleiro[linAlvo][colAlvo] == 'X') {
			tela[linAlvo][colAlvo] = 'X';
		}
		
		else {
			tela[linAlvo][colAlvo] = '~';
		}
		
		int acerto = checaDisparo (linAlvo, colAlvo, tabuleiro);
		
		if (acerto == 1) {
			imprimirTabuleiro (tela);
			disparo (tabuleiro, tela);
		}
		
		return tela;
	}

	
	public static int checaDisparo (int lin, int col, char[][] tabuleiro) {
		if (tabuleiro[lin][col] == 'X')
			return 1;
		
		else
			return 0;
	}
}
