package packproduct;

/**
 * Exception that gets raised when a given amount is negative
 * @author Oihan
 * @version v1
 */
@SuppressWarnings("serial")
public class NegativeAmountException extends Exception {
	/**
	 * NegativeAmountException class constructor
	 */
	public NegativeAmountException() {
		super();
	}
	
	/**
	 * NegativeAmountException class constructor, that takes a message as parameter
	 * @param s
	 */
	public NegativeAmountException(String s) { 
		super(s);
	}
}
