package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerMoveLeft implements Controller {
	
	private Paddle paddle;
	private float stepWidth;
	
	public PaddleControllerMoveLeft(Paddle paddle, float stepWidth) {
		this.paddle = paddle;
		this.stepWidth = stepWidth;
	}
	
	@Override
	public void handleEvent() {
		paddle.move(-stepWidth);
	}

}
