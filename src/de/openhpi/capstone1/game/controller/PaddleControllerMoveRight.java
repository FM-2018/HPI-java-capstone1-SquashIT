package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerMoveRight implements Controller {

	private Paddle paddle;
	private int stepWidth;
	
	public PaddleControllerMoveRight(Paddle paddle, int stepWidth) {
		this.paddle = paddle;
		this.stepWidth = stepWidth;
	}
	
	@Override
	public void handleEvent() {
		paddle.move(stepWidth);
	}

}
