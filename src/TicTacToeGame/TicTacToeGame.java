package TicTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {
	static int currentPlayer;
	static String winner;
	static String[] players=new String[2];
	
	public static void main(String[] args) {
		TicTacToe TTTBoard=new TicTacToe();
		winner=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Podaj imiê 1. gracza (X)...");
		players[0]=sc.nextLine();
		System.out.println("Podaj imiê 2. gracza (O)...");
		players[1]=sc.nextLine();
		currentPlayer=0;
		System.out.println("To gra w kó³ko i krzy¿yk");
		while (winner==null && !TTTBoard.endOfGame()) {
			TTTBoard.printBoard();
			System.out.println("Gracz: "+players[currentPlayer]);
			boolean isGoodMove=false;
			do {
				System.out.println("Podaj wspó³rzêdne Twojego ruchu (x,y)...");
				String coord=sc.nextLine();
				String[] coordinatesS=coord.split(",");
				int x=0;
				int y=0;
				try {
					x=Integer.parseInt(coordinatesS[0])-1;
					y=Integer.parseInt(coordinatesS[1])-1;
					isGoodMove=TTTBoard.move(x, y);
				}
				catch (IllegalArgumentException e) {
					System.out.println("B³¹d!");
					isGoodMove=false;
				}
				if (isGoodMove) {
					TTTBoard.board[x][y]=currentPlayer+1;
				}
			} while (!isGoodMove);
			if (currentPlayer==0) currentPlayer=1;
			else currentPlayer=0;
			winner=TTTBoard.checkWhoWon();
		}
		String winnerName="";
		if (TTTBoard.endOfGame()) {
			System.out.println("Nikt nie wygra³, koniec gry!");
			TTTBoard.printBoard();
		}
		else {
			if (winner.equals("X")) winnerName=players[0];
			else if (winner.equals("O")) winnerName=players[1];
			TTTBoard.printBoard();
			System.out.println("Wygra³eœ/aœ!");
			System.out.println("Gratulacje, "+winnerName+"!");
		}
		sc.close();
	}
}