package day06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
	
	public static enum Operation {TOGGLE, TURN_ON, TURN_OFF};
	
	public Operation operation;
	public Coordinates start, end;
	
	public Instruction(Operation operation, Coordinates start, Coordinates end) {
		this.operation = operation;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Parse operation from string of instruction
	 * 
	 * @param instruction
	 * @return
	 */
	public static Operation getOperation(String instruction) {
		Pattern toggle = Pattern.compile("toggle");
		Matcher matcher = toggle.matcher(instruction);
		if(matcher.find())
			return Operation.TOGGLE;
		
		Pattern turnOn = Pattern.compile("turn on");
		matcher = toggle.matcher(instruction);
		if(matcher.find())
			return Operation.TURN_ON;
		else
			return Operation.TURN_OFF;
	}

}
