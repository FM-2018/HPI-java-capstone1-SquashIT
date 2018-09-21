package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Ball;
import processing.core.PApplet;

public class BallView extends AbstractView {
	
	Ball ball;
	
	public BallView(PApplet display, Ball model) {
		super(display);
		this.ball = model;
	}
	
	@Override
	public void update() {
		display.stroke(0);
		display.fill(200);
		
		display.ellipse(ball.getX(), ball.getY(), ball.getRadius()*2, ball.getRadius()*2);
	}

}
