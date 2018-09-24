package de.openhpi.capstone1.game.model;

public class GameOverScreen {

	public String bestTime;
	
	public GameOverScreen(int[] bestTime) {
		int sec = bestTime[0];
		int tenth = bestTime[1];
		
		this.bestTime = sec + "." + tenth;
	}

}
