package packmusician;

/**
 * Exception that gets raised when a musician is already hired.
 * @author Oihan
 * @version 1
 */
@SuppressWarnings("serial")
public class AlreadyHiredMusician extends Exception {
	/**
	 * AlreadyHiredMusician class constructor.
	 */
	public AlreadyHiredMusician() {
		super();
	}
	
	/**
	 * AlreadyHiredMusician class constructor that takes exception message as parameter.
	 * @param msg the message to output if the exception is raised
	 */
	public AlreadyHiredMusician(String msg) {
		super(msg);
	}
	
}
