package tic_tac_toe.main;

import tic_tac_toe.model.Game;

public class ConsoleMain {
	
	private static Game game = new Game(); 

	public static void main(String[] args) {
		game.play(); 
	}

}
