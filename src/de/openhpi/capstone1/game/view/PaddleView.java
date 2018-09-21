package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Paddle;
import processing.core.PApplet;

public class PaddleView extends AbstractView {
	
	private Paddle paddle;

	public PaddleView(PApplet display, Paddle model) {
		super(display);
		this.paddle = model;
	}
	
	@Override
	public void update() {
		// TODO Draw/Update Paddle

	}

}
