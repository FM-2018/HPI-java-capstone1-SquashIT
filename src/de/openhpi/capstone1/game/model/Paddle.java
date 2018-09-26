package de.openhpi.capstone1.game.model;

public class Paddle extends PositionableElement {
	private float width;
	private float height;
	public float boundaryLeft;
	public float boundaryRight;
	
	public Paddle(float x, float y, float width, float height, float boundLeft, float boundRight) {
		super(x, y);
		this.width = width;
		this.height = height;
		boundaryLeft = boundLeft;
		boundaryRight = boundRight;
	}
	
	/**
	 * Move the paddle along the x-axis by a specified amount.
	 * @param amount if positive move right, if negative move left
	 */
	public void move(float amount) {
		xPos += amount;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
}
