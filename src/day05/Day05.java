package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 * 
 * Santa needs help figuring out which strings in his text file are naughty or
 * nice.
 * 
 * 
 * --- Part Two ---
 * 
 * Realizing the error of his ways, Santa has switched to a better model of
 * determining whether a string is naughty or nice. None of the old rules apply,
 * as they are all clearly ridiculous.
 * 
 * @author Martin Horava
 *
 */
public class Day05 {

    public static final String INPUT_FILE_PATH = "data/input05.txt";

    public static void main(String[] args) {
	int nice = 0;
	try {
	    List<String> strings = Files.readAllLines(Paths
		    .get(INPUT_FILE_PATH));
	    for (String string : strings) {
		if (isStringNice(string))
		    nice++;
	    }
	    System.out.println("Nice strings in Santa text file: " + nice);
	} catch (IOException e) {
	    System.out.println(e.getLocalizedMessage());
	}
    }

    /**
     * A nice string is one with all of the following properties: - It contains
     * at least three vowels (aeiou only) - It contains at least one letter that
     * appears twice in a row - It does not contain the strings ab, cd, pq, or
     * xy
     * 
     * @param string
     */
    public static boolean isStringNice(String input) {
	return hasThreeVowels(input) && hasDoubleLetter(input)
		&& !hasForbiddenStrings(input);
    }

    /**
     * This is function that test if string has at least three vowels.
     * 
     * @param input
     * @return
     */
    public static boolean hasThreeVowels(String input) {
	Pattern pattern = Pattern.compile("[aeiou]");
	Matcher matcher = pattern.matcher(input);
	return matcher.find() && matcher.find() && matcher.find();
    }

    /**
     * This is function that test if string has at least one double letter.
     * 
     * @param input
     * @return
     */
    public static boolean hasDoubleLetter(String input) {
	for (int i = 1; i < input.length(); i++) {
	    if (input.charAt(i - 1) == input.charAt(i))
		return true;
	}
	return false;
    }

    /**
     * This is function that test if string has any forbidden string.
     * 
     * @param input
     * @return
     */
    public static boolean hasForbiddenStrings(String input) {
	String[] forbidden = { "ab", "cd", "pq", "xy" };
	for (String forbid : forbidden) {
	    if (input.contains(forbid))
		return true;
	}
	return false;
    }

}
