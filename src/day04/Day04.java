package day04;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * --- Day 4: The Ideal Stocking Stuffer ---
 * 
 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use as
 * gifts for all the economically forward-thinking little girls and boys.
 * 
 * To do this, he needs to find MD5 hashes which, in hexadecimal, start with at
 * least five zeroes. The input to the MD5 hash is some secret key (your puzzle
 * input, given below) followed by a number in decimal. To mine AdventCoins, you
 * must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...)
 * that produces such a hash.
 * 
 * 
 * --- Part Two ---
 * 
 * Now find one that starts with six zeroes.
 * 
 * @author Martin Horava
 *
 */

public class Day04 {

    /**
     * Name of hash method
     */
    public static final String MD5 = "MD5";

    /**
     * Secret key
     */
    private static final String SECRET = "yzbqklnj";

    public static void main(String[] args) {
	try {
	    Long time = System.currentTimeMillis();
	    System.out
		    .println("Lowest number for hash with five leading zeros: "
			    + getHashWithLeadingZeros());
	    System.out
		    .println("Lowest number for hash with six leading zeros: "
			    + getHashWithSixLeadingZeros());
	    System.out.println("Time: " + (System.currentTimeMillis() - time)
		    + " ms");
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Compute hash with five leading zeros.
     * 
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static int getHashWithLeadingZeros()
	    throws NoSuchAlgorithmException, UnsupportedEncodingException {
	String condition = "^[0]{5,}+";
	return findHash(condition);
    }

    /**
     * Compute hash with six leading zeros.
     * 
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static int getHashWithSixLeadingZeros()
	    throws NoSuchAlgorithmException, UnsupportedEncodingException {
	String condition = "^[0]{6,}+";
	return findHash(condition);
    }

    /**
     * Find hash matching given condition.
     * 
     * @param condition
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static int findHash(String condition)
	    throws NoSuchAlgorithmException, UnsupportedEncodingException {
	int number = 0;
	Pattern pattern = Pattern.compile(condition);
	Matcher matcher = pattern.matcher(hash(SECRET + number));
	while (!matcher.find()) {
	    number++;
	    matcher = pattern.matcher(hash(SECRET + number));
	}
	System.out.println("Hash of " + SECRET + number + " is "
		+ hash(SECRET + number));
	return number;
    }

    /**
     * Create hash from string given by input.
     * 
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String hash(String input) throws NoSuchAlgorithmException,
	    UnsupportedEncodingException {
	MessageDigest digest;
	digest = MessageDigest.getInstance(MD5);
	byte[] hash = digest.digest(input.getBytes("UTF-8"));
	StringBuffer hexString = new StringBuffer();

	for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if (hex.length() == 1)
		hexString.append('0');
	    hexString.append(hex);
	}

	return hexString.toString();
    }

}
