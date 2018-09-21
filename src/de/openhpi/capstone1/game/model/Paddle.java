package de.openhpi.capstone1.game.model;

public class Paddle extends PositionableElement {
	int width;
	int height;
	
	public Paddle(int width, int height, int xPos, int yPos) {
		this.width = width;
		this.height = height;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Move the paddle along the x-axis by a specified amount.
	 * @param amount if positive move right, if negative move left
	 */
	public void move(int amount) {
		xPos += amount;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
