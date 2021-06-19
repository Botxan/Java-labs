package packlightbulb;

/**
 * Represents an halogen light bulb.
 * @author Oihan Irastorza
 * @version 1
 */
public class Halogen extends NonIncandescent {

	/**
	 * Halogen class consctructor. Calls to NonIncandescent superclass constructor.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 */
	public Halogen(String ID, double watts, double lumens) {
		super(ID, watts, lumens, false);
	}

}
