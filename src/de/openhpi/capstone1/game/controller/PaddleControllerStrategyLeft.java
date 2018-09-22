package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerStrategyLeft implements Controller {
	
	private PaddleControllerMoveLeft controllerMove;
	private PaddleControllerBoundary controllerBoundary;
	private Paddle paddle;
	private int stepWidth;
	
	public PaddleControllerStrategyLeft(Paddle paddle, int stepWidth) {
		controllerMove = new PaddleControllerMoveLeft(paddle, stepWidth);
		controllerBoundary = new PaddleControllerBoundary(paddle, stepWidth);
		this.paddle = paddle;
		this.stepWidth = stepWidth;
	}
	
	@Override
	public void handleEvent() {
		if (paddle.getX() - stepWidth <= paddle.boundaryLeft) {
			controllerBoundary.handleEvent();
		} else {
			controllerMove.handleEvent();
		}
	}

}
