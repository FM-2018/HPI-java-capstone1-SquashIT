package de.openhpi.capstone1.game.model;

public class GameField extends PositionableElement {
	private int width;
	private int distanceWindowTop;
	
	public GameField(int x, int width, int distanceWindowTop) {
		this.width = width;
		this.distanceWindowTop = distanceWindowTop;
		xPos = x;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getdistanceWindowTop() {
		return distanceWindowTop;
	}
}
