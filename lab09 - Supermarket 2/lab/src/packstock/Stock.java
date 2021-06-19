package packstock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import packproduct.NegativeAmountException;
import packproduct.Product;

/**
 * Class that allows to represent a Stock composed of Products
 * 
 * @author PMOO teachers, Oihan Irastorza
 * @version v1
 */
public class Stock {
	private ArrayList<Product> list;
	private static Stock instance;
	private int lastCode;

	/**
	 * Constructor without parameters that initializes the lastCode to 0 and creates
	 * an empty ArrayList of Products
	 */
	private Stock() {
		lastCode = 0;
		list = new ArrayList<Product>();
	}
	
	/**
	 * Returns the Stock class instance (following Singleton pattern)
	 * @return the Stock class instance
	 */
	public static Stock getInstance() {
		if (instance == null) instance = new Stock();
		return instance;
	}

	/**
	 * Increments the value of lastCode and returns it
	 * 
	 * @return the next code value
	 */
	public int getNextCode() {
		lastCode = lastCode + 1;
		return lastCode;
	}

	/**
	 * Adds a Product to the list
	 * 
	 * @param p the product to be added
	 */
	public void addProduct(Product p) {
		list.add(p);
	}

	/**
	 * Obtains the number of Products in the list
	 * 
	 * @return the number of products (list size)
	 */
	public int numberOfProducts() {
		return list.size();
	}

	/**
	 * Removes the given Product from the list. If the product does not exist, it shows a message
	 * 
	 * @param p the product that will be removed
	 */
	public void removeProduct(Product p) {
		if (!(list.remove(p)))
			System.out.println("The given product does not exist");
	}

	/**
	 * Removes the product with the given code from the list. If the product does not exist, it shows a message
	 * 
	 * @param code of the product that will be removed
	 * @throws UnknowCodeException if there is not product that matches the code
	 */
	public void removeProduct(int code) throws UnknowCodeException {
		Product p = new Product(code);
		if (!list.remove(p))
			throw new UnknowCodeException("The product with code "+ code + " does not exist");
	}

	/**
	 * Updates the amount of the product with the given code with the given amount
	 * 
	 * @param code code of the Product to be updated
	 * @param amount amount to set
	 * @throws NegativeAmountException if amount is negative
	 * @throws UnknowCodeException if there is not product that matches the code
	 */
	public void updateAmount(int code, int amount) throws NegativeAmountException, UnknowCodeException {
		Product p = new Product(code);
		int pos = list.indexOf(p);
		if (pos != -1) {
			list.get(pos).setAmount(amount);
		}else {
			throw new UnknowCodeException("The product with code "+ code + " does not exist");
		}
	}

	@Override // toString method from Object superclass
	public String toString() {
		String products = "";
		for (Product prod: list) {
			products += prod.toString() + "\n";
		} 
		return products;
	}
	
	/**
	 * Writes the stock on a file
	 */
	public void storeStockInFile() {
		try {
			// Create new file
			File stockFile = new File("./data/stock.txt"); // relative path
			
			// Check if it was already created
			if (!stockFile.createNewFile()) {
				System.out.println("File already exist. Will override the current stock.");
			}
			
			try {
				// Create the FileWriter object and pass by constructor argument
				// the file where is going to be writed the stock
				FileWriter writer = new FileWriter(stockFile);
				
				// Write process
				System.out.println("Writing...");
				writer.write(toString());
				System.out.println("Stock saved succesfully");
				writer.close();					
			} catch (IOException e) { // FileWriter error handling
				System.out.println("An error ocurred while trying to write on stock file.");
			}	
			
		} catch (IOException e) { // File error handling
			System.out.println("An error ocurred while creating the stock file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the product that matches the code passed by parameter
	 * @param code the product code
	 * @return a Product object that matches the code passed by parameter
	 * @throws UnknowCodeException is a product with specified code does not exist
	 */
	public Product obtainProduct (int code) throws UnknowCodeException {
		int index = list.indexOf(new Product(code));
		if (index == -1) throw new UnknowCodeException("The product with code "+ code + " does not exist");
		return list.get(index);
	}
	
	/** 
	 * Checks if the product passed by parameter is in the stock
	 * @param p the product to check if exist in stock
	 * @return true == the product is in the stock. Otherwise, returns false
	 */
	public boolean containsProduct(Product p) {
		return list.contains(new Product(p.getCode()));
	}

	/**
	 * Returns stock size
	 * @return stock size
	 */
	public int stockSize() {
		return list.size();
	}
	
	
	/**
	 * Exception that gets raised when a given product code doesn't match any product code inside the stock
	 * @author Oihan
	 * @version v1
	 */
	@SuppressWarnings("serial")
	public class UnknowCodeException extends Exception {
		
		/**
		 * UnknowCodeException class constructor
		 */
		public UnknowCodeException() {
			super();
		}		
		
		/**
		 * UnknowCodeException class constructor that takes a message as parameter
		 * @param s the message
		 */
		public UnknowCodeException(String s) {
			super(s);
		}
	}
	
	/**
	 * Returns a list of products that its amount is lesser than the number passed by parameter
	 * passed by parameter
	 * @param n the amount to filter
	 * @return a list of products that its amount is lesser than the amount passed by parameter
	 */
	public ArrayList<Product> obtainProductListToOrder(int n) {
		ArrayList<Product> order = new ArrayList<Product>();
		for (Product p: list) {
			if (p.getAmount() < n) {
				order.add(p);
			}
		}
		
		return order;
	}
	
	/**
	 * Removes all product from stock which its amount is 0
	 */
	public void removeAllProductsWith0Units() {		
		Iterator<Product> it = list.iterator();
		
		while (it.hasNext()) {
			Product p = it.next();
			if (p.getAmount() == 0) {
				it.remove();
			}
		}
		
	}
	
}
