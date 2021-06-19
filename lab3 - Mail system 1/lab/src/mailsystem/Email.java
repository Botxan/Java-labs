package mailsystem;

/**
 * The Email class implements mail creation and managing functionalities
 * @author PMOO teachers
 *
 * @version v1
 */
public class Email {
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	
	/**
	 * Email constructor. Calls to the others constructor and passes an empty text as text parameter
	 * @param sender mail sender
	 * @param receiver mail receiver
	 * @param subject mail subject
	 */
	public Email(String sender, String receiver, String subject) {
		this(sender, receiver, subject, "");
	}
	
	/**
	 * Email constructor. Initializes every attribute of email with its respective parameter
	 * @param sender mail sender
	 * @param receiver mail receiver
	 * @param subject mail subject
	 * @param text mail text
	 */
	public Email(String sender, String receiver, String subject, String text) {
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.text = text;
	};
		
	/**
	 * Returns the mail sender
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Returns the mail receiver
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	
	/**
	 * Returns the mail subject
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Returns the mail text
	 * @return the mail text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Modifies mail text
	 * @param text new mail text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Prints on standard output every attribute and their values
	 */
	public void showText() {
		System.out.println("Sender: " + sender);
		System.out.println("Receiver: " + receiver);
		System.out.println("Subject: " + subject);
		System.out.println("Text: " + text + "\n");
	}
	
	/**
	 * Checks if the receiver of the instanced object is equal to the one passed from parameter
	 * @param emailp mail whose receiver will be compared with the instanced object mail.
	 * actual (String)
	 * @return true = both mails have same receiver; false = different receiver. 
	 */
	public boolean equalsReceiver(Email emailp) {
		return receiver == emailp.receiver;
	}
	
}
