package day02;

import org.junit.Test;

import junit.framework.TestCase;

public class Day02Test extends TestCase {

    @Test
    public void test() {
	assertEquals(Day02.parseDimensionsAndComputeArea("2x3x4"), 58);
	assertEquals(Day02.parseDimensionsAndComputeArea("1x1x10"), 43);
    }

}
