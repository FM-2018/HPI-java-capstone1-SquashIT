package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.controller.Controller;
import de.openhpi.capstone1.game.model.Ball;

public class BallController implements Controller {

	Ball ball;
	
	public BallController(Ball ball) {
		this.ball = ball;
	}
	
	@Override
	public void handleEvent() {
		// TODO handle event ball controller

	}

}
