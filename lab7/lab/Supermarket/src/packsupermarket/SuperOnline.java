package packsupermarket;

import packproduct.*;
import packstock.*;
import packstock.Stock.UnknowCodeException;
/**
 * Demo class to test the implementation of Product and Stock
 * @author PMOO teacher, Oihan Irastorza
 * @version v1
 */
public class SuperOnline {
	
	/**
	 * SuperOnline main function
	 * @param args main args
	 */
	public static void main(String[] args) {
		Stock ins = new Stock();
		Product p1 = new Product(ins.getNextCode(), "banana", 2.3, 3, 1.0, 1);
		ins.addProduct(p1);

		try {
			ins.updateAmount(1, -10);
		} catch (NegativeAmountException | UnknowCodeException e) {
			e.printStackTrace();
		}
		
        try {
			ins.updateAmount(-12, 10);
		} catch (NegativeAmountException | UnknowCodeException e) {
			e.printStackTrace();
		}
        
        
		p1 = new Product(ins.getNextCode(), "milk", 1, 3, 1.0, 0.04);
		System.out.println(ins.toString());
		
			
		try {
			ins.removeProduct(1);
		} catch (UnknowCodeException e) {
			e.printStackTrace();
		}
		
		Product p2 = new Product(1001, "banana", 2.3, 50, 1.0, 0.04);
		Product p3 = new Product(1002, "gel_ducha", 1.58, 100, 1.2, 0.21);
		Product p4 = new Product(1003, "alitas_de_pollo", 2.13, 40, 0.5, 0.1);
		
		ins.addProduct(p2);
		ins.addProduct(p3);
		ins.addProduct(p4);
		
		// Try catch blocks for obtainProduct method testing
		try {
			@SuppressWarnings("unused")
			Product p2_clone = ins.obtainProduct(1001);
		} catch (UnknowCodeException e) {
			e.printStackTrace();
		}
		
		try {
			@SuppressWarnings("unused")
			Product unknownProduct = ins.obtainProduct(1050);
		} catch (UnknowCodeException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		ins.storeStockInFile();	
	}
	
}
