package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.exceptions.BallDepotDepletedException;

public class BallDepot extends PositionableElement {
	
	private Ball[] balls;
	private int ballAmountLeft;
	private float ballRadius;
	private float distanceBetweenBalls = 20;
	private float height;
	private float width;
	
	public BallDepot(float x, float y, float width, float height, Ball[] balls) {
		super(x, y);
		this.balls = balls;
		ballAmountLeft = balls.length;
		this.width = width;
		this.height = height;
		
		// TODO: if there's more than 4 balls, there should be support for multiple rows of balls
		float ballRadiusVert = (height - distanceBetweenBalls*(ballAmountLeft+1) ) / (ballAmountLeft*2); // radius each ball will have inside the depot
		float ballRadiusHorz = (width - 40);
		
		if (ballRadiusVert < ballRadiusHorz) {
			ballRadius = ballRadiusVert;
		} else {
			ballRadius = ballRadiusHorz;
			distanceBetweenBalls = (height - ballRadius*2*ballAmountLeft) / (ballAmountLeft+1);
		}
	}
	
	/**
	 * Return the next ball in the depot. If there are no more balls, throw an exception.
	 * @return The latest accessible Ball in the depot (shown in the view as the top ball)
	 * @throws BallDepotDepletedException The ball depot contains no more balls
	 */
	public Ball getNextBall() throws BallDepotDepletedException {
		try {
			Ball nextBall = balls[ballAmountLeft-1];
			ballAmountLeft--;
			return nextBall;			
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new BallDepotDepletedException("The ball depot contains no more balls.");
		}
	}
	
	public boolean isDepleted() {
		return ballAmountLeft < 1;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public int getBallAmountLeft() {
		return ballAmountLeft;
	}
	
	public float getBallRadius() {
		return ballRadius;
	}
	
	public float getDistanceBetweenBalls() {
		return distanceBetweenBalls;
	}

}
