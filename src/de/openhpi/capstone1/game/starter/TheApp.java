package de.openhpi.capstone1.game.starter;


import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.InteractiveComponentBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {
	
	InteractiveComponent interactiveComponent; // we only got one component for now, so an array/list is not necessary
	
	@Override
	public void settings() {
		size(800, 450); // format 16:9
	}

	@Override
	public void setup() {  // setup() runs once
		InteractiveComponentBuilder.create(this, "game");
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		interactiveComponent.update();
	}
	
	//Add further user interaction as necessary
	@Override
	public void keyPressed() {
		interactiveComponent.handleEvent();
	}
}
