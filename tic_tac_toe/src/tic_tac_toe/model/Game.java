package tic_tac_toe.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import tic_tac_toe.view.Board;

public class Game {
	
	private Board board;  
	private Scanner input = new Scanner(System.in); 
	private static Map<String, Character> playerMap = new HashMap<>(); 
	private String p1 = "Player 1"; 
	private String p2 = "Player 2"; 
	
	public Game() {
		 board = new Board(); 
	}
	
	public void play() {
		playerMap = createPlayerMap(); 
		boolean gameOver = false; 
		String whoGoesFirst = decideWhoGoesFirst(); 
		
		if (whoGoesFirst == p1) {
			System.out.println(p1 + " will go first.\n");
		} else {
			System.out.println(p2 + " will go first.\n");
			playerMap = ((TreeMap<String, Character>)playerMap).descendingMap();
		}
		
		while (!gameOver) {
			for (Map.Entry<String,Character> entry : playerMap.entrySet()) {
				System.out.print(entry.getKey() + " enter a row (0 , 1, or 2): "); 
				int row = input.nextInt(); 
				System.out.print("Enter a column (0, 1, or 2): ");
				int column = input.nextInt(); 
				
				makeMove(row, column, entry.getValue()); 
				board.displayBoard(); 
				
				if (isBoardFull()) {
					System.out.println("Draw. Game Over."); 
					gameOver = true;
					break;
				} 
				if (checkForWinner() == true) {
					System.out.println(entry.getKey() + " you win!"); 
					gameOver = true;
					break; 
				}
			}
		}
	}
	
	public Map<String, Character> createPlayerMap() {
		Map<String, Character> map = new HashMap<>();
		Map<String, Character> treeMap; 
		char selection = selectXorO(input);
		if (selection == 'X') {
			map.put(p1, 'X'); 
			map.put(p2, 'O'); 
			treeMap = new TreeMap<>(map); 
			return treeMap; 
		} else {
			map.put(p1, 'O'); 
			map.put(p2, 'X'); 
			treeMap = new TreeMap<>(map); 
			return treeMap;  
		}
	}
	
	
	public static char selectXorO(Scanner input) {
		char c; 
		System.out.print("Player 1, select X or O: "); 
		c = input.next().toUpperCase().charAt(0); 
		
		while (c != 'X' && c != 'O') {
			System.out.print("Player 1, select X or O: "); 
			c = input.next().toUpperCase().charAt(0); 
		}
		return c;
	}
	
	public String decideWhoGoesFirst() {
		int n = (int)(Math.random() * 2); 
		if (n == 0) {
			return p1; 
		} 
		return p2; 
	}
	
	public void makeMove(int row, int column, char c) {
		while (!isSpaceFree(row, column)) {
			System.out.println("Select another space");
		}
		board.getMatrix()[row][column] = c; 
	}
	 
	public boolean isBoardFull() {
		for (int row = 0; row < board.getMatrix().length; row++) {
			for (int column = 0; column < board.getMatrix()[row].length; column++) {
				if (isSpaceFree(row, column)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isSpaceFree(int row, int column) {
		if (board.getMatrix()[row][column] == ' ') {
			return true; 
		}
		return false;
	}
	
	public boolean checkForWinner() {
		if (checkRows() || checkColumns() || checkDiagonal() || checkDiagonalReverse()) {
			return true; 
		}
		return false; 
	}
	
	
	private boolean checkRows() {
		boolean matchedRow = true; 
		for (int row = 0; row < board.getMatrix().length; row++) {
			matchedRow = true; 
			if (board.getMatrix()[row][0] == ' ') {
				matchedRow = false; 
			} 
			for (int column = 0; column < board.getMatrix()[row].length; column++) {
				if (board.getMatrix()[row][0] != board.getMatrix()[row][column]) {
					matchedRow = false; 
					break; 
				} 
			}
			if (matchedRow == true) {
				return matchedRow; 
			}
		}
		return matchedRow; 
	}
	
	private boolean checkColumns() {
		boolean matchedColumn = true;
		for (int column = 0; column < board.getMatrix()[0].length; column++) {
			matchedColumn = true;
			if (board.getMatrix()[0][column] == ' ') {
				matchedColumn = false; 
			} 
			for (int row = 0; row < board.getMatrix().length; row++) {
				if (board.getMatrix()[0][column] != board.getMatrix()[row][column]) {
					matchedColumn = false;
					break;
				}
			}
			if (matchedColumn == true) {
				return matchedColumn; 
			}
		}
		return matchedColumn;
	}

	private boolean checkDiagonal() {
		boolean matchedDiagonal = false; 
		for (int row = 0, col = 0; row < board.getMatrix().length - 1; row++, col++) {
			matchedDiagonal = false; 
			if (board.getMatrix()[row][col] != ' ') {
				if (board.getMatrix()[row][col] == board.getMatrix()[row + 1][col + 1]) {
					matchedDiagonal = true; 
				}
			} else {
				return false; 
			}
		}
		return matchedDiagonal; 
	}
	
	private boolean checkDiagonalReverse() {		
		boolean matchedDiagonal = false;
		for (int row = 0, col = board.getMatrix().length - 1; row < board.getMatrix().length - 1; row++, col--) {
			if (board.getMatrix()[row][col] != ' ') {
				if (board.getMatrix()[row][col] == board.getMatrix()[row + 1][col - 1]) {
					matchedDiagonal = true; 
				}
			} else {
				return false; 
			}
		}
		return matchedDiagonal; 
	} 
	
	public Board getBoard() {
		return board; 
	}
 
}
