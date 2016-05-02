package day01;

import junit.framework.TestCase;

import org.junit.Test;

public class Day01Test extends TestCase {

    @Test
    public void test() {
	assertEquals(Day01.computeFloor("(())"), 0);
	assertEquals(Day01.computeFloor("()()"), 0);
	assertEquals(Day01.computeFloor("((("), 3);
	assertEquals(Day01.computeFloor("(()(()("), 3);
	assertEquals(Day01.computeFloor("))((((("), 3);
	assertEquals(Day01.computeFloor("())"), -1);
	assertEquals(Day01.computeFloor("))("), -1);
	assertEquals(Day01.computeFloor(")))"), -3);
	assertEquals(Day01.computeFloor(")())())"), -3);
    }

}
