package packlightbulb;

/**
 * Represents a non incandescent light bulb.
 * @author Oihan Irastorza
 * @version 1
 */
public class NonIncandescent extends Adjustable {
	boolean needsTransformer;
	
	/**
	 * NonIncandescent class constructor. Calls to Adjustable superclass consctructor,
	 * and initalizes needTransformer attribute.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 * @param needsTransformer boolean that shows whether the light bulb needs transformer or not.
	 */
	public NonIncandescent(String ID, double watts, double lumens, boolean needsTransformer) {
		super(ID, watts, lumens);
		this.needsTransformer = needsTransformer;
	}

	@Override
	public String toString() {
		return super.toString() + ", Needs transformer=" + needsTransformer;
	}

}
