package packmusician;

/**
 * Represents a soprano of an orchestra.
 * @author Oihan
 * @version 1
 */
public class Tenor extends Singer {
	
	/**
	 * Tenor class constructor. Calls to the superclass constructor.
	 * @param name name of the tenor.
	 */
	public Tenor(String name) {
		super(name);
	}
	
	@Override
	public String perform() {
		return "La-la-la-laaaaaaa";
	}
}
