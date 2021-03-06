package de.openhpi.capstone1.game.model;

public abstract class PositionableElement {
	float xPos;
	float yPos;
	
	public PositionableElement(float x, float y) {
		xPos = x;
		yPos = y;
	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public void setX(float x) {
		xPos = x;
	}
	
	public void setY(float y) {
		yPos = y;
	}
}
