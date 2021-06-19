package packlightbulb;

/**
 * Thrown when a LightBulb ID that does not match any LightBulb ID on an ArrayList is given.
 * @author Oihan
 *
 */
@SuppressWarnings("serial")
public class UnknownIdentifierException extends Exception {
	
	/**
	 * UnknownIdentifierException class constructor. Calls to Exception superclass constructor.
	 */
	public UnknownIdentifierException() {
		super();
	}
	
	/**
	 * UnknownIdentifierException class constructor. Calls to Exception superclass constructor
	 * and passes exception message as parameter.
	 * @param msg exception message
	 */
	public UnknownIdentifierException(String msg) {
		super(msg);
	}
}
