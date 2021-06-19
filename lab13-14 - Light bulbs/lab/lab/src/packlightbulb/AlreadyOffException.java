package packlightbulb;

/**
 * Thrown if an attempt is made to turn off a light bulb that is already off.
 * @author Oihan Irastorza
 * @version 1
 */
@SuppressWarnings("serial")
public class AlreadyOffException extends Exception {
	
	/**
	 * AlreadyOffException class constructor. Calls to Exception superclass constructor.
	 */
	public AlreadyOffException() {
		super();
	}
	
	/**
	 * AlreadyOffException class constructor. Calls to Exception superclass constructor
	 * and passes exception message as parameter.
	 * @param msg exception message
	 */
	public AlreadyOffException(String msg) {
		super(msg);
	}
}
