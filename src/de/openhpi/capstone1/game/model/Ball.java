package de.openhpi.capstone1.game.model;

public class Ball extends PositionableElement {
	private int radius;
	public int velocityX;
	public int velocityY;
	
	public Ball(int x, int y, int radius, int initialVelocityX, int initialVelocityY) {
		xPos = x;
		yPos = y;
		this.radius = radius;
		velocityX = initialVelocityX;
		velocityY = initialVelocityY;
	}
	
	/**
	 * Move the ball according to its current velocity.
	 */
	public void move() {
		// TODO move ball
	}
	
	public int getRadius() {
		return radius;
	}
	
}
