package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Timer;
import processing.core.PApplet;

public class TimerView extends AbstractView {

	Timer timer;
	
	public TimerView(PApplet display, Timer timer) {
		super(display);
		this.timer = timer;
	}

	@Override
	public void update() {
		display.textSize(timer.size);
		display.fill(0);
		
		String sec = timer.secondsCount + "";
		String tenth = timer.tenthSecondsCount + "";
		
		display.text(sec + "." + tenth, timer.getX(), timer.getY());
	}

}
