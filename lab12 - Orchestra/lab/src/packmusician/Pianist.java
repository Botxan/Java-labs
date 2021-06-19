package packmusician;

/**
 * Represents a pianist of an orchestra.
 * @author Oihan
 * @version 1
 */
public class Pianist extends Instrumentalist {
	
	/**
	 * Pianist class constructor. Initializes salary attribute and
	 * calls to superclass constructor.
	 * @param name pianist name
	 */
	public Pianist(String name) {
		super(name, "piano");
		setSalary(getSalary() + 1000);
	}
	
	@Override
	public String perform() {
		return "Ding-ting-dang-ding-tang-ting";
	}
}
