package day03;

import org.junit.Test;

import junit.framework.TestCase;

public class Day03Test extends TestCase {

    @Test
    public void test() {
	testSantaAlone();
	testSantaWithRoboSanta();
    }
    
    public void testSantaAlone() {
	assertEquals(Day03.santaAlone(">"), 2);
	assertEquals(Day03.santaAlone("^>v<"), 4);
	assertEquals(Day03.santaAlone("^v^v^v^v^v"), 2);
    }
    
    public void testSantaWithRoboSanta() {
	assertEquals(Day03.santaWithRoboSanta("^v"), 3);
	assertEquals(Day03.santaWithRoboSanta("^>v<"), 3);
	assertEquals(Day03.santaWithRoboSanta("^v^v^v^v^v"), 11);
    }

}
