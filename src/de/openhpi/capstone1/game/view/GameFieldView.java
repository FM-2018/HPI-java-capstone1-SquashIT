package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.GameField;
import processing.core.PApplet;

public class GameFieldView extends AbstractView {
	
	private GameField gameField;
	
	public GameFieldView(PApplet display, GameField model) {
		super(display);
		this.gameField = model;
	}
	
	@Override
	public void update() {
		display.stroke(0);
		display.fill(240);
		
		float topDistance = gameField.getTopBound();
		float width = gameField.getWidth();
		float x = gameField.getX();
		
		// Just imagine vertical and horizontal lines, which are accurately definable with only one given point
		float leftVertLine = x - width/2;
		float rightVertLine = x + width/2;
		float topHorizLine = topDistance;
		float bottomHorizLine = display.height+1; // Graphics designers hate him: make sure the border's stroke is not visible at the bottom with this simple trick! 
		
		// draw a rectangle defined by four points; namely where the lines intersect. Going counterclockwise, starting in the upper left corner.
		display.quad(leftVertLine, topHorizLine, leftVertLine, bottomHorizLine, rightVertLine, bottomHorizLine, rightVertLine, topHorizLine);
	}

}
