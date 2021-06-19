package packmusician;

/** 
 * Represents a soprano of an orchestra.
 * @author Oihan
 * @version 1
 */
public class Soprano extends Singer {
	private boolean international;
	
	/**
	 * Soprano class constructor. Initializes salary and international attributes,
	 * and calls to the superclass constructor.
	 * @param name name of the soprano
	 * @param international boolean that evaluates if the soprano is international.
	 */
	public Soprano(String name, boolean international) {
		super(name);
		this.international = international;
		if (international) setSalary(getSalary() + (getSalary() * 0.33));
	}
	
	@Override
	public String perform() {
		return "Li-li-li-liiiiiiiii";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", international=" + international;
	}
}
