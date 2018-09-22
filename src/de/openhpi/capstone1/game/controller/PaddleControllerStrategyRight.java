package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerStrategyRight implements Controller {

	private PaddleControllerMoveRight controllerMove;
	private PaddleControllerBoundary controllerBoundary;
	
	public PaddleControllerStrategyRight(Paddle paddle, int stepWidth) {
		controllerMove = new PaddleControllerMoveRight(paddle, stepWidth);
		controllerBoundary = new PaddleControllerBoundary(paddle, stepWidth);
	}
	
	@Override
	public void handleEvent() {
		// TODO handle paddle right

	}

}
