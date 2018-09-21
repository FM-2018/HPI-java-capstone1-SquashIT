package de.openhpi.capstone1.game.model;

public class Ball extends PositionableElement {
	private int radius;
	public int velocityX;
	public int velocityY;
	
	public Ball(int radius, int x, int y, int initialVelocityX, int initialVelocityY) {
		this.radius = radius;
		xPos = x;
		yPos = y;
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
