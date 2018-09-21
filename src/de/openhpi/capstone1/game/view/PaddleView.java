package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Paddle;
import processing.core.PApplet;
import processing.core.PConstants;

public class PaddleView extends AbstractView {
	
	private Paddle paddle;

	public PaddleView(PApplet display, Paddle model) {
		super(display);
		this.paddle = model;
	}
	
	@Override
	public void update() {
		display.rectMode(PConstants.CENTER);
		display.stroke(0);
		display.fill(200);
		
		display.rect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
	}

}
