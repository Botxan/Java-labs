package packlightbulb;

/**
 * Represents a fluorescent light bulb.
 * @author Oihan Irastorza
 * @version 1
 */
public class Fluorescent extends LightBulb implements security {

	private String primer;
	
	/**
	 * Fluorescent class constructor. Calls to LightBulb superclass constructor,
	 * and initializes primer attribute.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 * @param primer fluorescent primer
	 */
	public Fluorescent(String ID, double watts, double lumens, String primer) {
		super(ID, watts, lumens);
		this.primer = primer;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Primer=" + primer + ", Security=" + securityLevel(); 
	}

	/**
	 * The security level for fluorescent is calculated depending on primer.
	 */
	@Override
	public double securityLevel() {
		double security;
		if (primer.equalsIgnoreCase("DEOS ST171")) {
			security = 3;
		} else if (primer.equalsIgnoreCase("S2 4-22W SER")) {
			security = 2;
		} else {
			security = 1;
		}
		
		return security;
	}
}
