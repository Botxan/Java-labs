package packmusician;

/**
 * Represents a trumpeter of an orchestra.
 * @author Oihan
 * @version 1
 */
public class Trumpeter extends Instrumentalist {
	
	/**
	 * Trumpeter class constructor. Initializes salary attribute and
	 * calls to the superclass constructor.
	 * @param name trumpeter name
	 */
	public Trumpeter(String name) {
		super(name, "trumpet");
		setSalary(getSalary() + 100);
	}
	
	@Override
	public String perform() {
		return "Tu-ru-ru-tu-ru-ru";
	}
}
