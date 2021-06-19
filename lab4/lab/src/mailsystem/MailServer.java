package mailsystem;
import java.util.ArrayList;

/**
 * The MailServer class is used to simulate a mail server that can show and store mails
 * @author Oihan Irastorza
 * @version v2
 */
public class MailServer {
	
	// Attribute for storing mails
	private ArrayList<Email> mailList;

	/**
	 * MailServer Constructor initializes an empty mail list
	 */
	public MailServer() {
		mailList = new ArrayList<Email>();
	}
	
	/**
	 * Method that stores an Email at the end of the list
	 * @param pMail Email to be stored
	 */
	public void storeEmail(Email pMail) {
		mailList.add(pMail);
	}
	
	/**
	 * Method to show every mail stored in the server
	 */
	public void showAllEmails() {
		for (Email mail: mailList) mail.showText();
	}
	
	/**
	 * Empties the mail server by setting email counter to 0
	 */
	public void resetServer() {
		mailList.clear();
	}
	
	/**
	 * Prints every email whose receiver equals to the one passed from parameter
	 * @param receiver The receiver
	 */
	public void showInbox(String receiver) {
		for (Email mail: mailList) {
			if (mail.getReceiver() == receiver) mail.showText();
		}
	}
	
	/**
	 * Prints every email whose sender equals to the one passed from parameter
	 * @param user The sender
	 */
	public void showSentEmails(String user) {
		for (Email mail: mailList) {
			if (mail.getSender() == user) mail.showText();
		}
	}
	
	/**
	 * Removes the given mail from email list
	 * @param pmail The mail to remove
	 */
	public void removeEmail(Email pmail) {		
		for (int i = 0; i < mailList.size(); i++) {
			if (mailList.get(i).equals(pmail)) mailList.remove(i);
		}
	}
	
	/**
	 * Given a mail receiver, deletes the first occurrence of a mail whose
	 * receiver matches the one passed by parameter
	 * @param addr The mail receiver
	 * @return The email that has been deleted
	 */
	public Email obtainRemoveEmail(String addr) {
		for (Email mail: mailList) {
			if (mail.getReceiver() == addr) {
				Email temp = mail;
				removeEmail(obtainFirstEmail(addr));
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * Given a mail receiver, returns the first occurrence of a mail whose
	 * receiver matches the one passed by a parameter
	 * @param addr The mail receiver
	 * @return The first occurrence that matches the receiver passed by parameter
	 */
	private Email obtainFirstEmail(String addr) {
		for (Email mail: mailList) {
			if (mail.getReceiver() == addr) return mail;
		}
		return null;
	}
	
	/**
	 * Returns the number of mails in the server whose 
	 * receiver is the one passed by parameter
	 * @param receiver Receiver of the mails
	 * @return Amount of mails that matches the filter
	 */
	public int inboxSize(String receiver) {
		int count = 0;
		
		for (Email mail: mailList)
			if (mail.getReceiver() ==  receiver) count++;
		
		return count;
	}
	
	/**
	 * Returns every email whose sender and receiver matches the ones
	 * passed by parameter
	 * @param sender The mail sender
	 * @param receiver The mail receiver
	 */
	public void showEmailsFromTo(String sender, String receiver) {
		for (Email mail: mailList) {
			if (mail.getSender() == sender && mail.getReceiver() == receiver)
				mail.showText();
		}
	}
	
	/**
	 * Removes the nth mail whose receiver matches the one
	 * passed by parameter
	 * @param receiver The mail receiver
	 * @param n Nth email that matches the receiver
	 */
	public void removeEmailInbox(String receiver, int n) {
		if (inboxSize(receiver) >= n) {
			int count = 0;
			for (Email mail: mailList) {
				if (mail.getReceiver() == receiver) {
					count++;
					if (count == n) {
						removeEmail(mail);
						System.out.println("Email borrado");
					}
				}
			}
		} else {
			System.out.println("En el inbox del usuario no hay " + n + " o más emails.");
		}
	}
}
