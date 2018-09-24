package de.openhpi.capstone1.game.model;

public class GameField extends PositionableElement {
	private float width;
	private float distanceWindowTop;
	private float ballDeathLine;
	
	public GameField(float x, float width, float distanceWindowTop, float ballDeathLine) {
		this.width = width;
		this.distanceWindowTop = distanceWindowTop;
		xPos = x;
		this.ballDeathLine = ballDeathLine;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getBallDeathLine() {
		return ballDeathLine;
	}
	
	public float getTopBound() {
		return distanceWindowTop;
	}
	
	public float getLeftBound() {
		return xPos - width/2;
	}
	
	public float getRightBound() {
		return xPos + width/2;
	}
}
