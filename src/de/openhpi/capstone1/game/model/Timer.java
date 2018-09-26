package de.openhpi.capstone1.game.model;

import java.util.ArrayList;

public class Timer extends PositionableElement {
	
	public int tenthSecondsCount;
	public int secondsCount;
	public float size;
	
	public Timer(float x, float y, float size) {
		super(x, y);
		this.size = size;
	}
	
	public void incrementTenthSecondsCount() {
		tenthSecondsCount++;
		if (tenthSecondsCount % 10 == 0) {
			secondsCount++;
			tenthSecondsCount = 0;
		}
	}
	
	public int[] exportState() {
		return new int[] {secondsCount, tenthSecondsCount};
	}
	
	public void resetTimer() {
		tenthSecondsCount = 0;
		secondsCount = 0;
	}
	
	public static int[] findGreatestTime(ArrayList<int[]> timerResults) {
		
		int max_full_sec = 0;
		int max_tenth_sec = 0;
		for (int[] result : timerResults) {
			int this_full_sec = result[0];
			int this_tenth_sec = result[1];
			
			if (this_full_sec > max_full_sec) {
				max_full_sec = this_full_sec;
				max_tenth_sec = this_tenth_sec;
			} else if (this_full_sec == max_full_sec && this_tenth_sec > max_tenth_sec) {
				max_tenth_sec = this_tenth_sec;
			}
			
		}
		return new int[] {max_full_sec, max_tenth_sec};
	}
	
	
}
