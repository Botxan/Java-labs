package packlightbulb;

/**
 * Thrown if an attempt is made to turn on a light bulb that is already on.
 * @author Oihan Irastorza
 *
 */
@SuppressWarnings("serial")
public class AlreadyOnException extends Exception {
	
	/**
	 * AlreadyOnException class constructor. Calls to Exception superclass constructor.
	 */
	public AlreadyOnException() {
		super();
	}
	
	/**
	 * AlreadyOnException class constructor. Calls to Exception superclass constructor
	 * and passes exception message as parameter.
	 * @param msg exception message
	 */
	public AlreadyOnException(String msg) {
		super(msg);
	}
}
