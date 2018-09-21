package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Paddle;

public class PaddleControllerBoundary implements Controller {
	
	private Paddle paddle;
	private int stepWidth;
	
	public PaddleControllerBoundary(Paddle paddle, int stepWidth) {
		this.paddle = paddle;
		this.stepWidth = stepWidth;
	}
	
	@Override
	public void handleEvent() {
		// TODO handle even paddle controller boundary

	}

}
