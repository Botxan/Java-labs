package mailsystem;

/**
 * The MailClient class is used to simulate a mail user that will be connected to
 * a MailServer service. Once connected, the client is going to be able to manage
 * their inbox.
 * @author Oihan
 * @version v1
 */
public class MailClient {
	private MailServer server;
	private String userAddress;
	
	/**
	 * MailClient Constructor. Initializes server and userAddress properties with
	 * the values passed by parameters
	 * @param server Server that client will connect
	 * @param userAddress Name that represents the client
	 */
	public MailClient(MailServer server, String userAddress) {
		this.server = server;
		this.userAddress = userAddress;
	}
	
	/**
	 * Returns the user address
	 * @return UserAdress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	
	/**
	 * Stores an email with the data passed by parameters plus the userAddress as sender
	 * into mail server
	 * @param rec The mail receiver
	 * @param subj The mail subject
	 * @param text The mail body/text
	 */
	public void sendEmail(String rec, String subj, String text) {
		Email mail = new Email(userAddress, rec, subj, text);
		server.storeEmail(mail);
	}
	
	/**
	 * Sends to standard output all the mails whose receiver matches the
	 * client address
	 */
	public void showMyInbox() {
		server.showInbox(userAddress);
	}
	
	/**
	 * Sends to standard output all the mails whose sender matches the
	 * client address
	 */
	public void showSentEmails() {
		server.showSentEmails(userAddress);
	}
	
	/**
	 * Deletes from mail server the first occurrence of a mail whose receiver
	 * matches the user address
	 * @return The mail that has been deleted
	 */
	public Email obtainRemoveEmailFromInbox() {
		return server.obtainRemoveEmail(userAddress);
	}
	
	/**
	 * Deletes from mail server the nth mail that its receiver matches the userAddress
	 * @param n the nth mail to delete
	 */
	public void removeMyInboxEmail(int n) {
		server.removeEmailInbox(userAddress, n);
	}
	
	/**
	 * Returns a reply mail to the mail passed by parameter
	 * @param pMail The email to answer
	 * @param texto The text of the reply email
	 * @return the reply email with the new email and a copy of the old email
	 */
	public Email replyEmail(Email pMail, String texto) {
		if (pMail.getReceiver() == userAddress) {
			
			return new Email(
				pMail.getReceiver(),
				pMail.getSender(),
				"RP: " + pMail.getSubject(),
				texto + "\n" +
							
				// Print email to answer
				"\nSender: " + pMail.getSender() +
				"\nReceiver: " + pMail.getReceiver() +
				"\nSubject: " + pMail.getSubject() +
				"\n" + pMail.getText()
			);
			
		} else {
			System.out.println("El receptor del mensaje no concuerda con la dirección del cliente");
			return null;
		}
	}
}