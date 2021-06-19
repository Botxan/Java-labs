package mailSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {

	private Email mail1;
	private Email mail2;
	private Email mail3;	
	
	@BeforeEach
	void setUp() throws Exception {
		mail1 = new Email("send1", "rec1", "sub");
		mail2 = new Email("send2", "rec1", "sub");
		mail3 = new Email("send2", "rec2", "sub");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEqualsReceiver1() {
		//fail("Not yet implemented");
		assertTrue(mail1.equalsReceiver(mail2));
	}
	
	@Test
	void testEqualsReceiver2() {
		//fail("Not yet implemented");
		assertTrue(mail1.equalsReceiver(mail3), "Se esperaba el mismo receptor");
	}

}
