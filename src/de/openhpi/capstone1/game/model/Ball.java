package de.openhpi.capstone1.game.model;

public class Ball extends PositionableElement {
	private float radius;
	public float velocityX;
	public float velocityY;
	
	public Ball(float radius) {
		xPos = 0;
		yPos = 0;
		velocityX = 0;
		velocityY = 0;
		this.radius = radius; 
	}
	
	public Ball(float x, float y, float radius, float initialVelocityX, float initialVelocityY) {
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
		xPos += velocityX;
		yPos += velocityY;
	}
	
	/**
	 * Negate the ball's x-velocity after having traveled a certain x-distance
	 * @param distance The absolute x-distance after which the ball is going to bounce
	 * @exception IllegalArgumentException The given distance is greater than the ball's x-velocity
	 * @exception IllegalStateException The ball's current x-velocity is 0
	 */
	public void bounceX(float distance) {
		if (distance > Math.abs(velocityX)) {
			throw new IllegalArgumentException("The leftover distance to travel can't be greater than the ball's velocity.");
		}
		
		// Calculate the current movement-step with respect for how part of the velocity is 'used up' to make the ball move to the bounce-area
		if (velocityX > 0) {
			xPos += distance - (velocityX - distance);
		} else if (velocityX < 0) {
			xPos -= distance - (-velocityX - distance);
		} else {
			throw new IllegalStateException("The ball can't bounce in y-direction if its current x-velocity is 0.");
		}
		yPos += velocityY;
		
		// Negate the velocity to keep ball moving in this opposite direction
		velocityX *= -1;
	}
	
	/**
	 * Negate the ball's y-velocity after having traveled a certain y-distance
	 * @param distance The absolute y-distance after which the ball is going to bounce
	 * @exception IllegalArgumentException The given distance is greater than the ball's y-velocity
	 * @exception IllegalStateException The ball's current y-velocity is 0
	 */
	public void bounceY(float distance) {
		if (distance > Math.abs(velocityY)) {
			throw new IllegalArgumentException("The leftover distance to travel can't be greater than the ball's velocity.");
		}
		
		// Calculate the current movement-step with respect for how part of the velocity is 'used up' to make the ball move to the bounce-area
		if (velocityY > 0) {
			yPos += distance - (velocityY - distance);
		} else if (velocityY < 0) {
			yPos -= distance - (-velocityY - distance);
		} else {
			throw new IllegalStateException("The ball can't bounce in y-direction if its current y-velocity is 0.");
		}
		xPos += velocityX;
		
		// Negate the velocity to keep ball moving in this opposite direction
		velocityY *= -1;
	}
	
	public float getRadius() {
		return radius;
	}
	
}
