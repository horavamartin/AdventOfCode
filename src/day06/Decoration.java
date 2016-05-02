package day06;

import java.util.List;

/**
 * Interpretation of decoration matrix of lights
 * 
 * @author Martin Horava
 *
 */
public class Decoration {

	private static final int DECORATION_SIZE_X = 1000;
	private static final int DECORATION_SIZE_Y = 1000;
	/**
	 * Matrix of lights
	 */
	private boolean[][] lights;

	public Decoration() {
		lights = new boolean[1000][1000];
	}

	/**
	 * Go throw all instructions get from Santa
	 * 
	 * @param instructions
	 */
	public void runInstructions(List<Instruction> instructions) {
		for (Instruction instruction : instructions) {
			walk(instruction);
		}
	}

	/**
	 * Walk the instruction
	 * 
	 * @param instruction
	 */
	private void walk(Instruction instruction) {
		/*
		int startX, startY, endX, endY;
		if (instruction.start.x < instruction.end.x) {
			startX = instruction.start.x;
			endX = instruction.end.x;
		} else {
			startX = instruction.end.x;
			endX = instruction.start.x;
		}

		if (instruction.start.y < instruction.end.y) {
			startY = instruction.start.y;
			endY = instruction.end.y;
		} else {
			startY = instruction.end.y;
			endY = instruction.start.y;
		}
		 */
		for (int x = instruction.start.x; x < instruction.end.x; x++) {
			for (int y = instruction.start.y; y < instruction.end.y; y++) {
				switch (instruction.operation) {
				case TOGGLE:
					toggle(x, y);
					break;

				case TURN_ON:
					turnOn(x, y);
					break;

				case TURN_OFF:
					turnOff(x, y);
					break;
				}
			}
		}
	}

	/**
	 * Toggle the light
	 * 
	 * @param x
	 * @param y
	 */
	private void toggle(int x, int y) {
		lights[x][y] = !lights[x][y];
	}

	/**
	 * Turn on the light
	 * 
	 * @param x
	 * @param y
	 */
	private void turnOn(int x, int y) {
		lights[x][y] = true;
	}

	/**
	 * Turn off the light
	 * 
	 * @param x
	 * @param y
	 */
	private void turnOff(int x, int y) {
		lights[x][y] = false;
	}

	public void print() {
		
	}
	
	public int countLightOn() {
		int on = 0;
		for(int x = 0; x < DECORATION_SIZE_X; x++) {
			for(int y = 0; y < DECORATION_SIZE_Y; y++) {
				if(lights[x][y])
					on++;
			}
		}
		
		return on;
	}
}
