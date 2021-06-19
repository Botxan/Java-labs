package packUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "CounterTest Class")
class CounterTest {
	
	private Counter counter1;

	@BeforeEach
	void setUp() throws Exception {
		counter1 = new Counter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCounter() {
		fail("Not yet implemented");
	}

	@Test
	void testIncrement() {
		assertEquals(1, counter1.increment());
		assertEquals(2, counter1.increment());
		//fail("Not yet implemented");
	}

	@DisplayName(value = "testDecrement() method")
	@Test
	void testDecrement() {
		//fail("Not yet implemented");
		assertTrue(counter1.decrement() == -1, "testDecrement() no funciona correctamente");
	}

	@Test
	void testGetCount() {
		fail("Not yet implemented");
	}

}
