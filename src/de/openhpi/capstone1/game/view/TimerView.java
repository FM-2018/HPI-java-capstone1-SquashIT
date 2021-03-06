package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Timer;
import processing.core.PApplet;
import processing.core.PConstants;

public class TimerView extends AbstractView {

	private Timer timer;
	
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
		
		display.textSize(32);
		display.textAlign(PConstants.LEFT);
		display.text(sec + "." + tenth, timer.getX(), timer.getY());
	}

}
