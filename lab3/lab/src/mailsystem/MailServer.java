package mailsystem;

/**
 * The MailServer class is used to simulate a mail server that can show and store mails
 * @author PMOO teachers
 *
 */
public class MailServer {
	
	// Attribute for storing mails
	private Email emailList[];

	// Attribute for Maximum capacity
	private final int MAXIMUM_CAPACITY = 100;

	// Attribute for number of stored mails
	private int numEmails;

	/**
	 * MailServer Constructor initializes an empty mail list
	 */
	public MailServer() {
		emailList = new Email[MAXIMUM_CAPACITY];
		numEmails = 0;
	}
	
	/**
	 * Method that stores an Email at the end of the list
	 * @param pMail Email to be stored
	 */
	public void storeEmail(Email pMail) {
		if (numEmails < MAXIMUM_CAPACITY) {
			emailList[numEmails] = pMail;
			numEmails++;
		}
	}
	
	/**
	 * Method to show every mail stored in the server
	 */
	public void showAllEmails() {
		for (int i = 0; i < numEmails; i++) {
			emailList[i].showText();
		}		
	}
	
	/**
	 * Empties the mail server by setting email counter to 0
	 */
	public void resetServer() {
		numEmails = 0;
	}
	
	/**
	 * Prints every email whose receiver equals to the one passed from parameter
	 * @param user the receiver
	 */
	public void showInbox(String user) {
		for (int i = 0; i < numEmails; i++) {
			if (emailList[i].getReceiver() == user) {
				emailList[i].showText();
			}
		}
	}
	
	/**
	 * Prints every email whose sender equals to the one passed from parameter
	 * @param user the sender
	 */
	public void showSentEmails(String user) {
		for (int i = 0; i < numEmails; i++) {
			if (emailList[i].getSender() == user) {
				emailList[i].showText();
			}
		}
	}	
	
}
