package packlightbulb;

/**
 * The security interface implements a security level checker for leds that can be
 * placed in wet places.
 * @author Oihan
 * @version 1
 */
public interface security {
	/**
	 * Returns the security level of the light bulb.
	 * @return the security level
	 */
	public abstract double securityLevel();
}
