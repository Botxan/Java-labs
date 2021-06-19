package mailsystem;

/**
 * Class for simulating MailServer activity
 * @author PMOO Teachers
 * 	       Oihan Irastora
 * @version v2
 */
public class LabS04Simulator {

	/**
	 * Main method
	 * @param args - No parameters required
	 */
	public static void main(String[] args) {
		testEmail();
		testMailServer();
		testMailClient();
	}

	/**
	 * Method to test the  Email class
	 */
	public static void testEmail() {
		
		//Create an Email instance using the Constructor with all fields
		Email email1 = new Email("name1", "name2", "Mail subject 1", "Mail text 1");
	
		//Create an email instance using the Constructor with all fields but "text"
		Email email2 = new Email("name2", "name1", "Mail subject 2");
	
		//Use all different getters on email1 and email2
		System.out.println("email1 attributes (by getters):\n");
		System.out.println("Sender: " + email1.getSender());
		System.out.println("Receiver: " + email1.getReceiver());
		System.out.println("Subject: " + email1.getSubject());
		System.out.println("Text: " + email1.getText());
	
		System.out.println("\nemail2 attributes (by getters):");
		System.out.println("Sender: " + email2.getSender());
		System.out.println("Receiver: " + email2.getReceiver());
		System.out.println("Subject: " + email2.getSubject());
		System.out.println("Text: " + email2.getText());

		//Use setter to set text in email2
		email2.setText("Mail text 2 - by setter");
	
		//Check whether the value of the text attribute has changed (by its corresponding setter)
		System.out.println("\nText: " + email2.getText());
	}
	
	/**
	 * Method to test Email and MailServer classes
	 */
	public static void testMailServer() {
		MailServer insServer = new MailServer();
		
		Email email1 = new Email("user1", "user2", "testSubject0");
		insServer.storeEmail(email1);
		
		Email email2 = new Email("user1", "user2", "testSubject1");
		insServer.storeEmail(email2);
		
		Email email3 = new Email("user1", "user2", "testSubject2");
		insServer.storeEmail(email3);
		
		Email email4 = new Email("user2", "user1", "testSubject0");
		insServer.storeEmail(email4);
		
		insServer.showAllEmails();
		
		// Check equal senders
		System.out.println("Sender 1: " + email1.getSender() + ". Sender 2: " + email2.getSender() + ". Equals?");
		System.out.println(email1.equalsReceiver(email2));
		System.out.println("Sender 1: " + email1.getSender() + ". Sender 2: " + email4.getSender() + ". Equals?");
		System.out.println(email1.equalsReceiver(email4));
		
		System.out.println();
		
		String user = "user1";
		
		// Check equal receivers
		System.out.println("** Emails sent by " + user + " **");
		insServer.showSentEmails("user1");
		
		System.out.println();
		
		// Print all mails in mail server
		System.out.println("** " + user + "Inbox: " + " **");
		insServer.showInbox("user1");
		
		// Remove last email
		System.out.println("** Remove last mail from mail server **");
		insServer.removeEmail(email4);
		
		// Print all mails again
		System.out.println(" Emails on the server after deleting the last one: ");
		insServer.showAllEmails();
	}
	
	/** 
	 * Method to test Email, MailServer and MailClient classes
	 */
	public static void testMailClient() {
		MailServer insServer = new MailServer(); 
		MailClient mailClient1 = new MailClient(insServer, "client1");
		MailClient mailClient2 = new MailClient(insServer, "client2");
		
		for (int i = 0; i < 3; i++) mailClient1.sendEmail("client2", "Hi", "text" + i);
		mailClient2.sendEmail("client1", "Hi", "text0");
		
		System.out.println("** Emails sent by " + mailClient1.getUserAddress() + " **");
		mailClient1.showSentEmails();
		
		System.out.println("** " + mailClient1.getUserAddress() + " inbox **");
		mailClient1.showMyInbox();
		
		// Delete first mail of client1 (server side method)
		System.out.println("The following mail has been deleted from  " + mailClient1.getUserAddress() + " inbox:");
		insServer.obtainRemoveEmail(mailClient1.getUserAddress()).showText();
		
		// Delete first mail of client2 (client side method)
		System.out.println("The following mail has been deleted from  " + mailClient2.getUserAddress() + " inbox:");
		mailClient2.obtainRemoveEmailFromInbox().showText();
		
		System.out.println("Remainig mails on mail server: ");
		insServer.showAllEmails();
		
		
		// Complementary exercises
		
		System.out.println("** REPLY **");
		// Reply to email
		Email email1 = new Email("client1", "client2", "Salutatios", "Hi client! How are you?");
		Email replayEmail = mailClient2.replyEmail(email1, "Hi! Im fine!");
		replayEmail.showText();
	}	
}
