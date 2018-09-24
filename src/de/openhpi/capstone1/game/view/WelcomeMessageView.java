package de.openhpi.capstone1.game.view;

import processing.core.PApplet;
import processing.core.PConstants;

public class WelcomeMessageView extends AbstractView {

	public WelcomeMessageView(PApplet display) {
		super(display);
	}

	@Override
	public void update() {
		display.textSize(35);
		display.textAlign(PConstants.CENTER);
		display.fill(0);
		display.stroke(0);
		
		display.text("Welcome to SquashIT!", display.width/2, display.height/2);
		display.textSize(30);
		display.text("Press space to insert your first ball!", display.width/2, display.height/2+display.height*0.1f);

	}

}
