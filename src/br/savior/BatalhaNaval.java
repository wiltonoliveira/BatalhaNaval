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
		int win = 1;
		
		
		int qtdJogadores = numJog ();
				
		if (qtdJogadores == 1) {
			//tabuleiro1 = definirPosicao (tabuleiro1);
			tabuleiro2 = preencherIA (tabuleiro2);
			imprimirTabuleiro (tabuleiro2);
			
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
				
				if (checaWin (telaJ1, tabuleiro2) == 1) {
					System.out.println("\n\n\n************* Jogador 1 venceu ****************");
					win = 1;
					break;
				}
					
				System.out.println("\n\n\n\n\n\nVez do Jogador 2");
				imprimirTabuleiro (telaJ2);
				telaJ2 = disparo(tabuleiro1, telaJ2);
				
				if (checaWin (telaJ2, tabuleiro1) == 1) {
					System.out.println("\n\n\n************* Jogador 2 venceu ****************");
					win = 1;
					break;
				}
				
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
		System.out.println("POSICIONE O PORTA AVIÕES (5 QUADRADOS)");
		tabuleiro = portaAviao (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		
		
		System.out.println("POSICIONE O PRIMEIRO NAVIO TANQUE (4 QUADRADOS)");
		tabuleiro = navioTanque (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O SEGUNDO NAVIO TANQUE (4 QUADRADOS)");
		tabuleiro = navioTanque (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		
		System.out.println("POSICIONE O PRIMEIRO CONTRA TORPEDEIRO (3 QUADRADOS)");
		tabuleiro = contraTorpeideiro (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O SEGUNDO CONTRA TORPEDEIRO (3 QUADRADOS)");
		tabuleiro = contraTorpeideiro (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O TERCEIRO CONTRA TORPEDEIRO (3 QUADRADOS)");
		tabuleiro = contraTorpeideiro (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		
		System.out.println("POSICIONE O PRIMEIRO SUBMARINO (2 QUADRADOS)");
		tabuleiro = submarino (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O SEGUNDO SUBMARINO (2 QUADRADOS)");
		tabuleiro = submarino (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O TERCEIRO SUBMARINO (2 QUADRADOS)");
		tabuleiro = submarino (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
		System.out.println("POSICIONE O QUARTO SUBMARINO (2 QUADRADOS)");
		tabuleiro = submarino (tabuleiro, defLin(), defCol(), defOrien());
		imprimirTabuleiro (tabuleiro);
			
		
		return tabuleiro;
		
	}
	
	public static char[][] posicionar (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'X';
		return tabuleiro;
	}
	
	public static char[][] portaAviao (char[][]tabuleiro, int lin, int col, int orientacao){
			
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
	
	public static char[][] navioTanque (char[][]tabuleiro, int lin, int col, int orientacao){
		
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
	
	public static char[][] contraTorpeideiro (char[][]tabuleiro, int lin, int col, int orientacao){
		
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
	
	public static char[][] submarino (char[][]tabuleiro, int lin, int col, int orientacao){
		
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
	
	public static int checaWin (char[][] tela, char[][] tabuleiro) {
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tela[i][j] == '~')
					tabuleiro[i][j] = '~';
				
				
				if (tela[i][j] != tabuleiro[i][j])
					return 0;
			}
		}
		return 1;
	}
	
	public static int defLin () {
		Scanner scan = new Scanner (System.in);
		
		System.out.print("Digite a linha do alvo: ");
		int linAlvo = scan.nextInt();
		
		return linAlvo;
		
	}
	
	public static int defCol () {
		Scanner scan = new Scanner (System.in);
		
		System.out.print("Digite a coluna do alvo: ");
		int colAlvo = scan.nextInt();
		
		return colAlvo;
		
	}
	
	public static int defOrien () {
		Scanner scan = new Scanner (System.in);
		System.out.print("1 - HORIZONTAL ou 2 - VERTICAL: ");
		int orientacao = scan.nextInt();
		
		return orientacao;
	}
	
	public static char[][] preencherIA (char[][] tabuleiro) {
		tabuleiro = portaAviao (tabuleiro, 0, 0, 2);
		tabuleiro = navioTanque (tabuleiro, 5, 4, 1);
		tabuleiro = navioTanque (tabuleiro, 6, 1, 2);
		tabuleiro = contraTorpeideiro (tabuleiro, 1, 5, 2);
		tabuleiro = contraTorpeideiro (tabuleiro, 0, 9, 2);
		tabuleiro = contraTorpeideiro (tabuleiro, 7, 3, 1);
		tabuleiro = submarino (tabuleiro, 9, 3, 1);
		tabuleiro = submarino (tabuleiro, 6, 8, 2);
		tabuleiro = submarino (tabuleiro, 1, 2, 1);
		tabuleiro = submarino (tabuleiro, 0, 7, 3);
		
		return tabuleiro;
	}
}