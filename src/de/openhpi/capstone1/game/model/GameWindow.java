package de.openhpi.capstone1.game.model;

public class GameWindow extends PositionableElement {
	private int width;
	private int height;
	
	public GameWindow(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
