package mailSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailServerTest {
	
	Email email1;
	Email email2;
	MailServer mServer;
	ArrayList<Email> list;
	
	@BeforeEach
	void setUp() {
		email1 = new Email("Ainhoa", "Yeray", "Weekend plan");
		email2 = new Email("Yaiza", "Yeray", "Meeting Schedule");
		mServer = new MailServer();
		list = new ArrayList<Email>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStoreEmailEmptyServer1() {
		mServer.storeEmail(email1);
		list = mServer.getEmailList();
		// Check that server has only 1 email
		assertEquals(1, mServer.getNumEmails());
		// Check that the only email stored in the server is the one we are inserting
		assertTrue(list.get(0) == email1);
	}
	
	/**
	 * Test storeEmail() without using getEmailList()
	 */
	@Test
	void testStoreEmailEmptyServer2() {
		mServer.storeEmail(email1);
		// Check that server has only 1 email
		assertEquals(1, mServer.getNumEmails());	
		// Check that the only email stored in the server is the one we are inserting
		assertTrue(mServer.getEmailPos(0).equals(email1));
	}
	
	@Test
	void testStoreEmailNonEmptyServer1() {
		// pre stored email
		mServer.storeEmail(email1);	
		
		int numEmails = mServer.getNumEmails();
		
		mServer.storeEmail(email2);
		list = mServer.getEmailList();
		assertTrue(list.size() == numEmails+1);
		assertEquals(email2, list.get(numEmails));
	}
	
	/**
	 * Test storeEmail() without using getEmailList()
	 */
	@Test
	void testStoreEmailNonEmptyServer2() {
		// pre stored email
		mServer.storeEmail(email1);
	
		int numEmails = mServer.getNumEmails();
		
		mServer.storeEmail(email2);
		assertEquals(numEmails+1, mServer.getNumEmails());
		assertTrue(mServer.getEmailPos(numEmails).equals(email2));
	}
	
	@Test
	void testRemoveEmail() {
		// Will try to store 2 emails in the server
		testStoreEmailNonEmptyServer2();
		
		int numEmails = mServer.getNumEmails();
		
		mServer.removeEmail(email1);
		assertEquals(numEmails-1, mServer.getNumEmails());
	}

}
