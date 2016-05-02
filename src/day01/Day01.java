package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * --- Day 1: Not Quite Lisp ---
 * 
 * Santa was hoping for a white Christmas, but his weather machine's "snow"
 * function is powered by stars, and he's fresh out! To save Christmas, he needs
 * you to collect fifty stars by December 25th.
 * 
 * Collect stars by helping Santa solve puzzles. Two puzzles will be made
 * available on each day in the advent calendar; the second puzzle is unlocked
 * when you complete the first. Each puzzle grants one star. Good luck!
 * 
 * Here's an easy puzzle to warm you up.
 * 
 * Santa is trying to deliver presents in a large apartment building, but he
 * can't find the right floor - the directions he got are a little confusing. He
 * starts on the ground floor (floor 0) and then follows the instructions one
 * character at a time.
 * 
 * An opening parenthesis, (, means he should go up one floor, and a closing
 * parenthesis, ), means he should go down one floor.
 * 
 * The apartment building is very tall, and the basement is very deep; he will
 * never find the top or bottom floors.
 * 
 * For example: (()) and ()() both result in floor 0. ((( and (()(()( both
 * result in floor 3. ))((((( also results in floor 3. ()) and ))( both result
 * in floor -1 (the first basement level). ))) and )())()) both result in floor
 * -3.
 * 
 * @author Martin Horava
 *
 */

public class Day01 {

    /**
     * Upper floor sign
     */
    public static char UPPER_FLOOR = '(';

    /**
     * Lower floor sign
     */
    public static char LOWER_FLOOR = ')';

    /**
     * Path to input file
     */
    public static final String inputFilePath = "data/input01";

    public static void main(String[] args) {
	String input = "";
	if (input.isEmpty()) {
	    try {
		input = readInputFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	System.out.println("Santa should go to the floor: "
		+ computeFloor(input));
    }

    /**
     * Read and parse input file into one string.
     * 
     * @return
     * @throws IOException
     */
    public static String readInputFile() throws IOException {
	StringBuilder inputString = new StringBuilder();
	List<String> input = Files.readAllLines(Paths.get(inputFilePath));

	for (String string : input)
	    inputString.append(string);
	return inputString.toString();
    }

    /**
     * Compute floor from string of parenthesis
     * 
     * @param input
     * @return
     */

    public static int computeFloor(String input) {
	int floor = 0, position = 0;
	boolean basementVisited = false;

	while (position < input.length()) {
	    char c = input.charAt(position);
	    if (c == UPPER_FLOOR)
		floor++;
	    if (c == LOWER_FLOOR)
		floor--;
	    position++;
	    if (!basementVisited && floor == -1) {
		System.out.println("Santa went to basement at first at: "
			+ position);
		basementVisited = true;
	    }
	}
	return floor;
    }
}