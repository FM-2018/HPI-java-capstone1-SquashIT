package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.GameWindow;
import de.openhpi.capstone1.game.model.Paddle;
import processing.core.PApplet;

public class Game extends InteractiveComponent {
	
	private PApplet display;
	GameWindow gameWindow;
	Paddle paddle;
	Ball ball;
	
	@Override
	public void handleEvent() {
		// TODO Handle input events in interactive component.
	}
	
	@Override
	public void buildModels() {
		// TODO Build models in interactive component.
	}
	
	@Override
	public void buildViews(PApplet display) {
		// TODO Build views in interactive component.
	}
	
	@Override
	public void buildControllers() {
		// TODO Build controllers in interactive component.
	}

}
