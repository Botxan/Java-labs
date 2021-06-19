package packproduct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private Product p1;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Product(89032475);
	}
	
	@Test
	void testSetAmountNegative() {
		assertThrows(NegativeAmountException.class, () -> p1.setAmount(-50));
	}

	@Test
	void testSetAmountPositive() {
		try {
			p1.setAmount(50);
		} catch (NegativeAmountException e) {
			fail("setAmount() reaised an unexpected exception");
		}
		assertEquals(p1.getAmount(), 50);
	}
	
	@Test
	void testAmountZero() {
		try {
			p1.setAmount(0);
		} catch(NegativeAmountException e) {
			fail("setAmount raised an unexpected exception");
		}		
		assertEquals(p1.getAmount(), 0);
	}

}
