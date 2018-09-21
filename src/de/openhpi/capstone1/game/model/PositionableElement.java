package de.openhpi.capstone1.game.model;

public abstract class PositionableElement {
	int xPos;
	int yPos;
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void setX(int x) {
		xPos = x;
	}
	
	public void setY(int y) {
		yPos = y;
	}
}
