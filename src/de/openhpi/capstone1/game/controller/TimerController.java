package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Timer;

public class TimerController implements Controller {

	Timer timer;
	int framesTillHundrethIncrease;
	int frameCount = 0;
	
	public TimerController(Timer timer, float frameRate) {
		this.timer = timer;
		framesTillHundrethIncrease = Math.round( (frameRate)/10 ); // have to accept inaccuracies here with frameRates that are not evenly divisible by 10
	}
	
	@Override
	public void handleEvent() {
		frameCount++;
		
		if (frameCount % framesTillHundrethIncrease == 0) {
			timer.incrementTenthSecondsCount();
			frameCount = 0;
		}
	}

}
