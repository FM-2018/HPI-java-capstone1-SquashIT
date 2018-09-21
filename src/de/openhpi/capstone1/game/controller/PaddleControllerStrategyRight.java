package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerStrategyRight implements Controller {

	Paddle paddle;
	
	public PaddleControllerStrategyRight(Paddle paddle, int stepWidth) {
		this.paddle = paddle;
	}
	
	@Override
	public void handleEvent() {
		// TODO handle paddle right

	}

}
