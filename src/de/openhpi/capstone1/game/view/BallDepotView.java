package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.BallDepot;
import processing.core.PApplet;
import processing.core.PConstants;

public class BallDepotView extends AbstractView {

	private BallDepot ballDepot;
	
	public BallDepotView(PApplet display, BallDepot ballDepot) {
		super(display);
		this.ballDepot = ballDepot;
	}

	@Override
	public void update() {
		display.rectMode(PConstants.CENTER);
		display.fill(255);
		display.stroke(0);
		
		// draw depot box
		display.rect(ballDepot.getX(), ballDepot.getY(), ballDepot.getWidth(), ballDepot.getHeight());
		
		
		// draw contained balls
		display.fill(200);
		
		float ballRadius = ballDepot.getBallRadius();
		for (int i = 0; i < ballDepot.getBallAmountLeft(); i++) {
			float y = ( ballDepot.getY() + ballDepot.getHeight()/2 ) - ballDepot.getDistanceBetweenBalls()*(i+1) - ballRadius*(2*i+1);
			display.ellipse(ballDepot.getX(), y, ballRadius, ballRadius);
		}
		
		// draw description
		display.textSize(26);
		display.textAlign(PConstants.LEFT);
		display.fill(0);
		display.text("Balls", ballDepot.getX()-ballDepot.getWidth()/2 + 2, ballDepot.getY()-ballDepot.getHeight()/2 - 5);
	}

}
