package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * --- Day 2: I Was Told There Would Be No Math ---
 * 
 * The elves are running low on wrapping paper, and so they need to submit an
 * order for more. They have a list of the dimensions (length l, width w, and
 * height h) of each present, and only want to order exactly as much as they
 * need.
 * 
 * Fortunately, every present is a box (a perfect right rectangular prism),
 * which makes calculating the required wrapping paper for each gift a little
 * easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The
 * elves also need a little extra paper for each present: the area of the
 * smallest side.
 * 
 * For example:
 * 
 * A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of
 * wrapping paper plus 6 square feet of slack, for a total of 58 square feet. A
 * present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of
 * wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
 * 
 * 
 * 
 * @author Martin Horava
 *
 */
public class Day02 {

    /**
     * Path to input file.
     */
    public static final String INPUT_FILE_PATH = "data/input02";

    public static void main(String[] args) {
	try {
	    System.out.printf("Size of wrapping paper is: %d feets\n",
		    readFileAndCompute(INPUT_FILE_PATH));
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    System.out.println(e.getLocalizedMessage());
	}
    }

    /**
     * Read input from file and parse it into data.
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static int readFileAndCompute(String path) throws Exception {
	int size = 0, partSize = 0;
	List<String> lines = Files.readAllLines(Paths.get(path));
	Pattern pattern = Pattern.compile("[0-9]+x[0-9]+x[0-9]+");
	for (String line : lines) {
	    Matcher matcher = pattern.matcher(line);
	    if (matcher.find()) {
		partSize = parseDimensionsAndComputeArea(matcher.group());
		size += partSize;
	    } else {
		throw new Exception("Invalid input");
	    }
	}
	return size;
    }

    /**
     * Parse dimensions of box and computes size of wrapping paper
     * 
     * @param input
     * @return
     */
    public static int parseDimensionsAndComputeArea(String input) {
	int width = 0, height = 0, length = 0;
	Pattern patter = Pattern.compile("[0-9]+");
	Matcher matcher = patter.matcher(input);
	if (matcher.find())
	    width = Integer.parseInt(matcher.group());
	if (matcher.find())
	    height = Integer.parseInt(matcher.group());
	if (matcher.find())
	    length = Integer.parseInt(matcher.group());
	return computeArea(width, height, length);
    }

    /**
     * Computes area of wrapping paper needed for one box with slack. As slack
     * is used the smallest side of box.
     * 
     * @param width
     * @param height
     * @param length
     * @return size of wrapping paper
     */
    public static int computeArea(int width, int height, int length) {
	int sideA = width * height;
	int sideB = width * length;
	int sideC = height * length;
	System.out.printf("2*%d + 2*%d + 2*%d + %d = ", sideA, sideB, sideC,
		smallestArea(sideA, sideB, sideC));
	return 2 * sideA + 2 * sideB + 2 * sideC
		+ smallestArea(sideA, sideB, sideC);
    }

    /**
     * Choose the smallest area for extra paper
     * 
     * @param sideA
     * @param sideB
     * @param sideC
     * @return
     */
    public static int smallestArea(int sideA, int sideB, int sideC) {
	if (sideA < sideB && sideA < sideC) {
	    return sideA;
	} else if (sideB < sideA && sideB < sideC) {
	    return sideB;
	} else {
	    return sideC;
	}
    }
}