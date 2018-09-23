package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.AbstractView;
import processing.core.PApplet;

public abstract class InteractiveComponent {
	public abstract void handleEvent();
	protected AbstractView[] views; 
	
	public void update() {
		updateViews();
	}
	
	public void updateViews() {
		for (AbstractView view : views) {
			view.update(); 
		}
	}
	
	public abstract void buildModels();
	public abstract void buildViews(PApplet display);
	public abstract void buildControllers();
	
}
