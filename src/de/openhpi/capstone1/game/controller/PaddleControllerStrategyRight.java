package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerStrategyRight implements Controller {

	private PaddleControllerMoveRight controllerMove;
	private PaddleControllerBoundary controllerBoundary;
	private Paddle paddle;
	private float stepWidth;
	
	public PaddleControllerStrategyRight(Paddle paddle, float stepWidth) {
		controllerMove = new PaddleControllerMoveRight(paddle, stepWidth);
		controllerBoundary = new PaddleControllerBoundary(paddle);
		this.paddle = paddle;
		this.stepWidth = stepWidth;
	}
	
	@Override
	public void handleEvent() {
		if (paddle.getX() + stepWidth >= paddle.boundaryRight) {
			controllerBoundary.handleEvent();
		} else {
			controllerMove.handleEvent();
		}
	}

}
