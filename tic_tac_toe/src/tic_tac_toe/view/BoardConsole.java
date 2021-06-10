package tic_tac_toe.view;


public class BoardConsole { 
	
	private char[][] board; 
	
	public BoardConsole() {
		board = new char[3][3]; 
		initializeSpaces(); 
	}
	
	public void displayBoard() { 
		displayBanner(); 
		 
		System.out.printf("\n%s\n", "-------------");
		System.out.printf("%s%2c%2s%2c%2s%2c%2s\n", "|", getMatrix()[0][0], "|", getMatrix()[0][1], "|", getMatrix()[0][2], "|");
		System.out.printf("%s\n", "-------------");
		System.out.printf("%s%2c%2s%2c%2s%2c%2s\n", "|", getMatrix()[1][0], "|", getMatrix()[1][1], "|", getMatrix()[1][2], "|");
		System.out.printf("%s\n", "-------------");
		System.out.printf("%s%2c%2s%2c%2s%2c%2s\n", "|", getMatrix()[2][0], "|", getMatrix()[2][1], "|", getMatrix()[2][2], "|");
		System.out.printf("%s\n", "-------------");
	}
	
	private void displayBanner() {
		System.out.printf("%4s\n", "Tic"); 
		System.out.printf("%8s\n", "Tac");
		System.out.printf("%12s", "Toe");
	}
	
	private void initializeSpaces() {
		for (int row = 0; row < getMatrix().length; row++) {
			for (int column = 0; column < getMatrix()[row].length; column++) {
				board[row][column] = ' '; 
			}
		}
	}

	public char[][] getMatrix() {
		return board;
	}


}
