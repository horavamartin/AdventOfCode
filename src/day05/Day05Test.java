package day05;

import org.junit.Test;

import junit.framework.TestCase;

public class Day05Test extends TestCase {

    @Test
    public void test() {
	assertTrue(Day05.isStringNice("ugknbfddgicrmopn"));
	assertTrue(Day05.isStringNice("aaa"));
	assertFalse(Day05.isStringNice("jchzalrnumimnmhp"));
	assertFalse(Day05.isStringNice("haegwjzuvuyypxyu"));
	assertFalse(Day05.isStringNice("dvszwmarrgswjxmb"));
    }

}
