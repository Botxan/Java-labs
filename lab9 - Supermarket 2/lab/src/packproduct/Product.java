package packproduct;

/**
 * Class that represents Products
 * @author PMOO teachers, Oihan Irastorza
 * @version v1
 */
public class Product {
	private int code;
	private String name;
	private double price;
	private int amount;
	private double weight;
	private final double VAT;
	
	/**
	 * Product class constructor. Chains the call to a larger constructor
	 * @param code product code
	 */
	public Product(int code) {
		this(code, "", 0.0, 0, 0.0, 0.21);
	}

	/**
	 * Product class constructor. Initializes every attribute
	 * @param code product code
	 * @param name product name
	 * @param price product price
	 * @param amount product amount
	 * @param weight product weight
	 * @param VAT product VAT
	 */
	public Product(int code, String name, double price, int amount, double weight, double VAT) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.weight = weight;
		this.VAT = VAT;
	}

	/**
	 * Code getter
	 * @return product code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Code setter
	 * @param code product code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Name getter
	 * @return product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name setter
	 * @param name product name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Price getter
	 * @return product price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Price setter
	 * @param price product price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Amount getter
	 * @return product amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Amount setter
	 * @param amount product amount
	 * @throws NegativeAmountException if amount is negative
	 */
	public void setAmount(int amount) throws NegativeAmountException {
		if (amount < 0) throw new NegativeAmountException("The amount can not be negative.");
		this.amount = amount;
	}
	
	/**
	 * Weight getter
	 * @return product weight
	 */
	public double getWeight() {	
		return weight;
	}
	
	/**
	 * Weight setter
	 * @param weigth product weight
	 * @throws NegativeAmountException if weight is negative
	 */
	public void setWeight (double weigth) throws NegativeAmountException {
		if (amount < 0) throw new NegativeAmountException("The weight can not be negative.");
		this.weight = weigth;
	}

	/**
	 * VAT getter
	 * @return the VAT of the product
	 */
	public double getVAT() {
		return VAT;
	}		

	@Override // toString() method from Object superclass
	public String toString() {
		return code + " " + name + " " + price + " " + amount + " " + weight +  " " + VAT;
	}

	@Override // equals() method from Object superclass
	public boolean equals(Object obj) {
		final Product prod = (Product) obj;
		return code == prod.code;
	}
}
