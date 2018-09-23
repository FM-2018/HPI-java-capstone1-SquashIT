package de.openhpi.capstone1.game.model;

public class GameField extends PositionableElement {
	private int width;
	private int distanceWindowTop;
	private int ballDeathLine;
	
	public GameField(int x, int width, int distanceWindowTop, int ballDeathLine) {
		this.width = width;
		this.distanceWindowTop = distanceWindowTop;
		xPos = x;
		this.ballDeathLine = ballDeathLine;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getBallDeathLine() {
		return ballDeathLine;
	}
	
	public int getTopBound() {
		return distanceWindowTop;
	}
	
	public int getLeftBound() {
		return xPos - width/2;
	}
	
	public int getRightBound() {
		return xPos + width/2;
	}
}
