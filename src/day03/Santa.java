package day03;

import java.util.HashMap;

/**
 * Stores houses that santa visits,
 * 
 * @author Martin Horava
 * 
 */
public class Santa {

    /**
     * Map of all visited houses
     */
    protected HashMap<House, Integer> visitsCount;

    /**
     * String of Santa instructions
     */
    protected String instructions;

    /**
     * Current coordinates
     */
    protected int x, y;

    public Santa(String instructions) {
	this.visitsCount = new HashMap<House, Integer>();
	visitsCount.put(new House(0, 0), 1);
	this.instructions = instructions;
    }

    /**
     * Return count of visited houses.
     * 
     * @return
     */
    public int getVisitedCount() {
	return visitsCount.size();
    }

    /**
     * Visit all houses by instructions.
     */
    public void visitAll() {
	x = 0;
	y = 0;
	for (int pos = 0; pos < instructions.length(); pos++) {
	    goNextHouse(instructions.charAt(pos));
	}
    }

    /**
     * Visit all houses by instructions with RoboSanta. So Santa visits every
     * second house by direction. Not every house.
     */
    public void visitAllWithRoboSanta() {
	x = 0;
	y = 0;
	for (int pos = 0; pos < instructions.length(); pos = pos + 2) {
	    goNextHouse(instructions.charAt(pos));
	}
    }

    /**
     * Go to next house by direction and change coordinates.
     * 
     * @param instruction
     */
    protected void goNextHouse(char instruction) {
	switch (instruction) {
	/* North */
	case '^':
	    x++;
	    break;
	/* South */
	case 'v':
	    x--;
	    break;
	/* East */
	case '>':
	    y++;
	    break;
	/* West */
	case '<':
	    y--;
	    break;
	default:
	    System.out.println("Wrong input.");
	    break;
	}
	visitHouse(x, y);
    }

    /**
     * Increment house counter in map of all houses.
     * 
     * @param x
     * @param y
     */
    protected void visitHouse(int x, int y) {
	House house = new House(x, y);
	if (visitsCount.containsKey(house)) {
	    visitsCount.put(house, visitsCount.get(house) + 1);
	} else {
	    visitsCount.put(house, 1);
	}
    }

}
