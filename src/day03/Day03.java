package day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 * 
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * 
 * He begins by delivering a present to the house at his starting location, and
 * then an elf at the North Pole calls him via radio and tells him where to move
 * next. Moves are always exactly one house to the north (^), south (v), east
 * (>), or west (<). After each move, he delivers another present to the house
 * at his new location.
 * 
 * However, the elf back at the north pole has had a little too much eggnog, and
 * so his directions are a little off, and Santa ends up visiting some houses
 * more than once. How many houses receive at least one present?
 * 
 * --- Part Two ---
 * 
 * The next year, to speed up the process, Santa creates a robot version of
 * himself, Robo-Santa, to deliver presents with him.
 * 
 * Santa and Robo-Santa start at the same location (delivering two presents to
 * the same starting house), then take turns moving based on instructions from
 * the elf, who is eggnoggedly reading from the same script as the previous
 * year.
 * 
 * @author Martin Horava
 *
 */
public class Day03 {

    /**
     * Path to input file
     */
    public static String INPUT_FILE_PATH = "data/input03";

    public static void main(String[] args) {
	String input = null;
	try {
	    input = String.join("",
		    Files.readAllLines(Paths.get(INPUT_FILE_PATH)));
	} catch (IOException e) {
	    System.out.println(e.getLocalizedMessage());
	}

	santaAlone(input);
	santaWithRoboSanta(input);
    }

    /**
     * Count how many houses Santa visits more than once.
     * 
     * @param input
     */
    public static int santaAlone(String input) {
	Santa santa = new Santa(input);
	santa.visitAll();
	int visited = santa.getVisitedCount();
	System.out
		.println("Count of visited houses by Santa alone: " + visited);
	return visited;
    }

    /**
     * Count how many houses gets at leas one present.
     * 
     * @param instructions
     */
    public static int santaWithRoboSanta(String instructions) {
	RoboSanta roboSanta = new RoboSanta(instructions);
	roboSanta.visitAllWithRoboSanta();
	int visited = roboSanta.getVisitedCount();
	System.out.println("Count of visited houses by Santa and Robo-Santa: "
		+ visited);
	return visited;
    }
}
