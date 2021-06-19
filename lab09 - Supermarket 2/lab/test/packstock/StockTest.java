package packstock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packproduct.Product;
import packstock.Stock.UnknowCodeException;

class StockTest {

	Stock ins;
	
	@BeforeEach
	void setUp() throws Exception {
		ins = Stock.getInstance();
	}

	@Test
	void testGetNextCode() {
		assertEquals(ins.getNextCode(), 1);
		assertEquals(ins.getNextCode(), 2);
	}

	@Test
	void testObtainProductExist() {
		ins.addProduct(new Product(834975));
		
		try {
			ins.obtainProduct(834975);
		} catch (UnknowCodeException e) {
			fail("obtainProduct() raised an unexpected exception");
		}
	}
	
	@Test
	void testObtainProductNotExist() {
		ins.addProduct(new Product(834975));
		assertThrows(UnknowCodeException.class, () -> ins.obtainProduct(1));
	}
	
	@Test
	void testRemoveProductExist() {
		ins.addProduct(new Product(834975));
		
		try {
			ins.removeProduct(834975);
		} catch (UnknowCodeException e) {
			fail("removeProduct() raised an unexpected exception");
		}
	}
	
	@Test
	void testRemoveProductNotExist() {
		ins.addProduct(new Product(834975));
		
		assertThrows(UnknowCodeException.class, () -> ins.removeProduct(1));
	}

}
