package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.GameOverScreen;
import processing.core.PApplet;
import processing.core.PConstants;

public class GameOverScreenView extends AbstractView {

	GameOverScreen gameOverScreen;
	
	public GameOverScreenView(PApplet display, GameOverScreen gameOverScreen) {
		super(display);
		this.gameOverScreen = gameOverScreen;
	}

	@Override
	public void update() {
		display.fill(0);
		display.stroke(0);
		
		display.quad(0, 0, 0, display.height, display.width, display.height, display.width, 0); // fill whole screen with black
		
		display.fill(255);
		display.textSize(40);
		display.textAlign(PConstants.CENTER);
		
		display.text("GAME OVER", display.width/2, display.height*0.3f);
		
		display.text("Your best time was " + gameOverScreen.bestTime + "!", display.width/2, display.height*0.45f);
	}

}
