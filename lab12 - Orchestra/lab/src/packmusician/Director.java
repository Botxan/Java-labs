package packmusician;

/** 
 * Represents the director of an orchestra.
 * @author Oihan
 *
 */
public class Director extends Musician {
	private int antiquity;
	
	/**
	 * Director class constructor. Initializes calls to the superclass constructor.
	 * @param name director name
	 */
	public Director(String name) {
		super(name);
		setSalary(getSalary() + 300);
	}
	
	/**
	 * Getter for antiquity.
	 * @return director antiquity in the orchestra 
	 */
	public int getAntiquity() {
		return antiquity;
	}
	
	/**
	 * Setter for antiquity.
	 * @param antiquity director antiquity
	 */
	public void setAntiquity(int antiquity) {
		this.antiquity = antiquity;
		setSalary(getSalary() + ((800 * 0.05) * antiquity));
	}
	
	@Override
	public String perform() {
		return "Tok tok tok: (silence)";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", antiquity=" + antiquity;
	}
}
