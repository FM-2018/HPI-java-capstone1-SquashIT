package de.openhpi.capstone1.game.model;

public class Paddle extends PositionableElement {
	private int width;
	private int height;
	public int boundaryLeft;
	public int boundaryRight;
	
	public Paddle(int xPos, int yPos, int width, int height, int boundLeft, int boundRight) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		boundaryLeft = boundLeft;
		boundaryRight = boundRight;
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
