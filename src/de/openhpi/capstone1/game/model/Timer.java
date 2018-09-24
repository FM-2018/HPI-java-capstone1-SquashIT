package de.openhpi.capstone1.game.model;

public class Timer extends PositionableElement {
	
	public int tenthSecondsCount;
	public int secondsCount;
	public float size;
	
	public Timer(float x, float y, float size) {
		xPos = x;
		yPos = y;
		this.size = size;
	}
	
	public void incrementTenthSecondsCount() {
		tenthSecondsCount++;
		if (tenthSecondsCount % 10 == 0) {
			secondsCount++;
			tenthSecondsCount = 0;
		}
	}
	
	
}
