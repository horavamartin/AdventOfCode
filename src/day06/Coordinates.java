package day06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {

	public int x, y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Coordinates parseCoordinates(String coordinates) throws Exception {
		int x, y;
		Pattern toggle = Pattern.compile("\\d+");
		Matcher matcher = toggle.matcher(coordinates);
		if(matcher.find()) {
			x = Integer.parseInt(matcher.group());
		} else {
			throw new Exception("Invalid coordinates");
		}
		
		if(matcher.find()) {
			y = Integer.parseInt(matcher.group());
		} else {
			throw new Exception("Invalid coordinates");
		}
		return new Coordinates(x, y);
	}
	
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}

}
