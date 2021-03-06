package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.GameField;
import processing.core.PApplet;

public class GameFieldView extends AbstractView {
	
	private GameField gameField;
	
	public GameFieldView(PApplet display, GameField gameField) {
		super(display);
		this.gameField = gameField;
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
		float bottomHorizLine = display.height; 
		
		// draw a rectangle defined by four points; namely where the lines intersect. Going counterclockwise, starting in the upper left corner.
		display.quad(leftVertLine, topHorizLine, leftVertLine, bottomHorizLine, rightVertLine, bottomHorizLine, rightVertLine, topHorizLine);
	}

}
