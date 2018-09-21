package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class Paddle extends AbstractView {
	
	private Paddle paddle;

	public Paddle(PApplet display, Paddle model) {
		super(display);
		this.paddle = model;
	}
	
	@Override
	public void update() {
		// TODO Draw/Update Paddle

	}

}
