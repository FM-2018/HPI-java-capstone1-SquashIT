package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.GameWindow;
import processing.core.PApplet;

public class GameWindowView extends AbstractView {
	
	private GameWindow gameWindow;
	
	public GameWindowView(PApplet display, GameWindow model) {
		super(display);
		this.gameWindow = model;
	}
	
	@Override
	public void update() {
		// TODO Draw/Update Window
	}

}
