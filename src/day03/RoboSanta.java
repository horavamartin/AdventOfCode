package day03;

/**
 * RoboSanta
 * 
 * @author Martin Horava
 *
 */
public class RoboSanta extends Santa {

    public RoboSanta(String instructions) {
	super(instructions);
    }

    /**
     * Visit all houses by Santa and RoboSanta.
     */
    public void visitAllWithRoboSanta() {
	visitAllBySanta();
	visitAllByRoboSanta();
    }

    /**
     * Santa visiting houses
     */
    private void visitAllBySanta() {
	x = 0;
	y = 0;
	for (int pos = 0; pos < instructions.length(); pos = pos + 2) {
	    goNextHouse(instructions.charAt(pos));
	}
    }

    /**
     * RoboSanta visiting houses
     */
    private void visitAllByRoboSanta() {
	x = 0;
	y = 0;
	for (int pos = 1; pos < instructions.length(); pos = pos + 2) {
	    goNextHouse(instructions.charAt(pos));
	}
    }

}
