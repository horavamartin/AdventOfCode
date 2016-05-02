package day06;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * --- Day 6: Probably a Fire Hazard ---
 * 
 * Because your neighbors keep defeating you in the holiday house decorating
 * contest year after year, you've decided to deploy one million lights in a
 * 1000x1000 grid.
 * 
 * Furthermore, because you've been especially nice this year, Santa has mailed
 * you instructions on how to display the ideal lighting configuration.
 * 
 * Lights in your grid are numbered from 0 to 999 in each direction; the lights
 * at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions
 * include whether to turn on, turn off, or toggle various inclusive ranges
 * given as coordinate pairs. Each coordinate pair represents opposite corners
 * of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore
 * refers to 9 lights in a 3x3 square. The lights all start turned off.
 * 
 * To defeat your neighbors this year, all you have to do is set up your lights
 * by doing the instructions Santa sent you in order.
 * 
 * @author Martin Horava
 *
 */
public class Main {

    public static final String INPUT_FILE_PATH = "data/input06.txt";

    public static void main(String[] args) {
	Decoration decoration = new Decoration();
	try {
	    List<Instruction> instructions = parseInstructionFromFile();
	    decoration.runInstructions(instructions);
	    System.out.println(decoration.countLightOn());
	} catch (Exception e) {
	    System.out.println(e.getLocalizedMessage());
	}
    }

    public static List<Instruction> parseInstructionFromFile() throws Exception {
	List<Instruction> instructions = new ArrayList<>();
	List<String> strings = Files.readAllLines(Paths.get(INPUT_FILE_PATH));
	for (String instruction : strings) {
	    instructions.add(new Instruction(Instruction
		    .getOperation(instruction), parseStart(instruction),
		    parseEnd(instruction)));
	}
	return instructions;
    }

    public static Coordinates parseStart(String instruction) throws Exception {
	instruction = instruction.split("through")[0];
	return Coordinates.parseCoordinates(instruction);
    }

    public static Coordinates parseEnd(String instruction) throws Exception {
	instruction = instruction.split("through")[1];
	return Coordinates.parseCoordinates(instruction);
    }

}
