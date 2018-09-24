package de.openhpi.capstone1.game.starter;


import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.InteractiveComponentBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {
	
	private InteractiveComponent interactiveComponent; // we only got one component for now, so an array/list is not necessary
	
	@Override
	public void settings() {
		size(800, 450); // format 16:9
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(60); // only use integers here
		frameRate = (float) 60.0; // for some reason, frameRate method doesn't seem to update frameRate to 60. It would remain 10.  I need the proper value for the Game to read, though.
		interactiveComponent = InteractiveComponentBuilder.create(this, InteractiveComponentBuilder.GAME);
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(180);
		interactiveComponent.update();
	}
	
	//Add further user interaction as necessary
	@Override
	public void keyPressed() {
		interactiveComponent.handleEvent();
	}
}
