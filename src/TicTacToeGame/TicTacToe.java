package TicTacToeGame;

public class TicTacToe {
	public int[][] board;
	public TicTacToe() {
		board=new int[3][3];
	}
	public void printBoard() {
		StringBuilder s=new StringBuilder("  1   2   3 \n");
		for (int i=0;i<3;i++) {
			s.append(i+1);
			for (int j=0;j<3;j++) {
				if (board[j][i]==0) {
					s.append("   ");
				}
				else if (board[j][i]==1) {
					s.append(" X ");
				}
				else {
					s.append(" O ");
				}
				if (j<2) s.append("|");
			}
			s.append("\n");
			if (i<2) s.append(" ---|---|---\n");
		}
		System.out.println(s);
	}
	
	public boolean move(int x,int y) {
		if (x<0 || x>2 || y<0 || y>2) return false;
		else {
			if (board[x][y]==0) return true;
			else return false;
		}
	}
	public boolean endOfGame() {
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if (board[i][j]==0) return false;
			}
		}
		return true;
	}
	
	public String checkWhoWon() {
		if (board[0][0]==1 && board[0][1]==1 && board[0][2]==1) return "X";
		else if (board[1][0]==1 && board[1][1]==1 && board[1][2]==1) return "X";
		else if (board[2][0]==1 && board[2][1]==1 && board[2][2]==1) return "X";
		else if (board[0][0]==1 && board[1][0]==1 && board[2][0]==1) return "X";
		else if (board[0][1]==1 && board[1][1]==1 && board[2][1]==1) return "X";
		else if (board[0][2]==1 && board[1][2]==1 && board[2][2]==1) return "X";
		else if (board[0][0]==1 && board[1][1]==1 && board[2][2]==1) return "X";
		else if (board[2][0]==1 && board[1][1]==1 && board[0][2]==1) return "X";
		
		else if (board[0][0]==2 && board[0][1]==2 && board[0][2]==2) return "O";
		else if (board[1][0]==2 && board[1][1]==2 && board[1][2]==2) return "O";
		else if (board[2][0]==2 && board[2][1]==2 && board[2][2]==2) return "O";
		else if (board[0][0]==2 && board[1][0]==2 && board[2][0]==2) return "O";
		else if (board[0][1]==2 && board[1][1]==2 && board[2][1]==2) return "O";
		else if (board[0][2]==2 && board[1][2]==2 && board[2][2]==2) return "O";
		else if (board[0][0]==2 && board[1][1]==2 && board[2][2]==2) return "O";
		else if (board[2][0]==2 && board[1][1]==2 && board[0][2]==2) return "O";
		
		else return null;
	}

}
