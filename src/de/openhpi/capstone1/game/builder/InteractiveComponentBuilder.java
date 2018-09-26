package de.openhpi.capstone1.game.builder;

import java.text.MessageFormat;

import processing.core.PApplet;

public class InteractiveComponentBuilder {
	public static final int GAME = 0x6A4E; // constant used to select type of InteractiveComponent to build
	
	public static InteractiveComponent create(PApplet applet, int type) {
		InteractiveComponent component;
		
		switch (type) {
			case GAME:
				component = new Game(applet);
				
				component.buildModels();
				component.buildViews(applet);
				component.buildControllers();
				break;
			default:
				String error_msg = MessageFormat.format("No buildable component for type '{0}' exists.", type);
				throw new RuntimeException(error_msg);
		}

		
		return component;
	}
}
