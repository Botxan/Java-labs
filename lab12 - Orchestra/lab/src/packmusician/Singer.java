package packmusician;

/**
 * Represents a singer of an orchestra.
 * @author Oihan
 * @version 1
 */
public class Singer extends Musician {
	
	/**
	 * Singer class constructor. Initializes salary and calls to the superclass constructor.
	 * @param name singer name
	 */
	public Singer(String name) {
		super(name);
		setSalary(getSalary() + 200);
	}
}
