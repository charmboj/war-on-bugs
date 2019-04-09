/* LAUNCHER PROGRAM */


package rpg.framework.main;

import rpg.framework.display.Display; // imports the Display package

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("Sample", 600, 450); // sets game parameters 
		game.start(); // starts the game
	}
}
