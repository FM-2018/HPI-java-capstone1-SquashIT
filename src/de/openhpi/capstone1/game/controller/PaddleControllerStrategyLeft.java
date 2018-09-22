package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerStrategyLeft implements Controller {
	
	private PaddleControllerMoveLeft controllerMove;
	private PaddleControllerBoundary controllerBoundary;
	
	public PaddleControllerStrategyLeft(Paddle paddle, int stepWidth) {
		controllerMove = new PaddleControllerMoveLeft(paddle, stepWidth);
		controllerBoundary = new PaddleControllerBoundary(paddle, stepWidth);
	}
	
	@Override
	public void handleEvent() {
		// TODO Handle paddle-left event with strategies

	}

}
