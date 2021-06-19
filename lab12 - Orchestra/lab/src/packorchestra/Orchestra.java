package packorchestra;

import java.util.ArrayList;

import packmusician.*;

/**
 * Represents an orchestra, with all its musicians.
 * @author Oihan
 *
 */
public class Orchestra {
	private String name;
	ArrayList<Musician> musicians;
	
	/**
	 * Orchestra class constructor. Initializes name atribute and the 
	 * array list that will contain every musician in the orchestra.
	 * @param name orchestra name
	 */
	public Orchestra(String name) {
		this.name = name;
		musicians = new ArrayList<Musician>();
	}
	
	/**
	 * Getter for name attribute.
	 * @return orchestra name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Makes the hiring process given a musician.
	 * @param musician the musician that is going to be hired.
	 * @return musician's salary
	 */
	public String hire(Musician musician) {
		try {
			musician.hire();
			musicians.add(musician);
		} catch (AlreadyHiredMusician e) {
			System.out.println(e.getMessage());
		}
		
		return Double.toString(musician.getSalary());
	}
	
	/**
	 * Writes a message indicating the name of the orchestra. Then, writes the performance
	 * of the director. And finally, writes the performance of the rest of the musicians in
	 * the orchestra.
	 */
	public void act() {
		boolean foundDirector = false;
		int i = 0;
		
		// Orchestra name
		System.out.println("This is the " + name + " performance:");
		
		// Director performance
		while (!foundDirector && i < musicians.size()) {
			Musician musician = musicians.get(i);
			if (musician.getClass() == Director.class) {
				foundDirector = true;
				System.out.println(musician.perform());
			}
			i++;
		}
		
		// Rest of musicians performance
		for (Musician musician: musicians) {
			if (musician.getClass() != Director.class) System.out.println(musician.perform());
		}
	}
	
	/**
	 * Returns the price for an orchestra performance. 
	 * @return the price for an orchestra performance
	 */
	public double getFee() {
		double fee = 0;
		for (Musician musician: musicians) {
			fee += musician.getSalary();
		}		
		return fee;
	}
	
	@Override
	public String toString() {
		String orchestra = "";
		for (Musician musician: musicians) orchestra += musician.toString() + "\n";
		return orchestra;
	}
}
