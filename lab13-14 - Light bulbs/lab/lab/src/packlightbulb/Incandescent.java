package packlightbulb;

/**
 * Represents an incandescent light bulb.
 * @author Oihan Irastorza
 * @version 1
 */
public class Incandescent extends Adjustable {

	/**
	 * Incandescent class constructor. Calls to Adjustable superclass constructor.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 */
	public Incandescent(String ID, double watts, double lumens) {
		super(ID, watts, lumens);
	}
}
