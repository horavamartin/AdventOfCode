package day03;

/**
 * 
 * House with coordinates
 * 
 * @author Martin Horava
 *
 */
public class House {

    /**
     * Coordinate of house
     */
    private int x = 0, y = 0;

    public House(int x, int y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public boolean equals(Object arg0) {
	if (this == arg0)
	    return true;

	if (arg0 instanceof House) {
	    House house = (House) arg0;
	    return equalsCoordinates(house, this);
	}

	return false;
    }

    /**
     * Compare coordinates of two houses.
     * 
     * @param house1
     * @param house2
     * @return
     */
    public static boolean equalsCoordinates(House house1, House house2) {
	return house1.x == house2.x && house1.y == house2.y;
    }

    @Override
    public int hashCode() {
	return 691 * x + 251 * y;
    }
}
