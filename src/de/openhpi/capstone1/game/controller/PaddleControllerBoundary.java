package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerBoundary implements Controller {
	
	private Paddle paddle;
	
	public PaddleControllerBoundary(Paddle paddle) {
		this.paddle = paddle;
	}
	
	@Override
	public void handleEvent() {
		// Snap back to either the left or the right boundary; depending on which one the paddle is closest to.
		float distLeft = paddle.getX() - paddle.boundaryLeft;
		float distRight = paddle.boundaryRight - paddle.getX();
		
		if (distLeft < distRight) {
			paddle.setX(paddle.boundaryLeft);
		} else if (distRight < distLeft) {
			paddle.setX(paddle.boundaryRight);
		} else {
			// The paddle is exactly in the middle. Do nothing.
		}

	}

}
