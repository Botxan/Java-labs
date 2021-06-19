package packmusician;

/** 
 * Represents a musician in general.
 * @author Oihan
 * @version 1
 * 
 */
public class Musician {
	private String name;
	private double salary;
	private boolean hired;
	
	/**
	 * Musician class constructor. Initializes name, salary and hired atributes.
	 * @param name musician name
	 */
	public Musician(String name) {
		this.name = name;
		salary = 500.0;
		hired = false;
	}
	
	/**
	 * Name getter.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Salary getter
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Hired attribute getter.
	 * @return a boolean (hired) depending if the musician is hired in any orchestra or not
	 */
	public boolean isHired() {
		return hired;
	}
	
	/**
	 * Name setter
	 * @param name musician's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Salary setter
	 * @param salary musician's salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * Simulates the hiring of an employee.
	 * @throws AlreadyHiredMusician if the musician is already hired
	 */
	public void hire() throws AlreadyHiredMusician {
		if (hired) {
			throw new AlreadyHiredMusician("The musician " + getName() + " is already hired");
		} else {
			hired = true;
		}
	}
	
	/**
	 * Returns an string that represents the performance of the musician.
	 * @return an string that represents the performance of the musician
	 */
	public String perform() {
		return "ssssss";
	}
	
	@Override // from Object superclass
	public boolean equals(Object obj) {
		Musician musician = (Musician) obj;
		return musician.name.equals(name);
	}
	
	@Override // from Object superclass
	public String toString() {
		return this.getClass().getSimpleName() + " name=" + name + ", salary=" + salary + ", hired=" + hired;
	}	
}
