package packdemo;

import packmusician.*;
import packorchestra.Orchestra;

/**
 * The DemoOrchestra class is used for testing every class related to the orchestra. This means
 * the Orchestra class itself and every class related with the musicians.
 * @author Oihan
 * @version 1
 */
public class DemoOrchestra {
	
	/**
	 * Main method.
	 * @param args no parameters required
	 */
	public static void main(String[] args) {		
		Director director = new Director("Director1");
		director.setAntiquity(15);
		Pianist pianist = new Pianist("Pianist1");
		Soprano soprano1 = new Soprano("Soprano1", true);
		Soprano soprano2 = new Soprano("Soprano2", false);
		Tenor tenor = new Tenor("Tenor1");
		Trumpeter trumpeter1 = new Trumpeter("Trumpeter1");
		Trumpeter trumpeter2 = new Trumpeter("Trumpeter2");
		
		// Print every musician
		Orchestra orchestra = new Orchestra("Orchestra1");
		System.out.println(director.getName() + " " + director.getClass().getSimpleName() + ", hired for " + orchestra.hire(director) + " euros");
		System.out.println(pianist.getName() + " " + pianist.getClass().getSimpleName() + ", hired for " + orchestra.hire(pianist) + " euros");
		System.out.println(soprano1.getName() + " " + soprano1.getClass().getSimpleName() + ", hired for " + orchestra.hire(soprano1) + " euros");
		System.out.println(soprano2.getName() + " " + soprano2.getClass().getSimpleName() + ", hired for " + orchestra.hire(soprano2) + " euros");
		System.out.println(tenor.getName() + " " + tenor.getClass().getSimpleName() + ", hired for " + orchestra.hire(tenor) + " euros");
		System.out.println(trumpeter1.getName() + " " + trumpeter1.getClass().getSimpleName() + ", hired for " + orchestra.hire(trumpeter1) + " euros");
		System.out.println(trumpeter2.getName() + " " + trumpeter2.getClass().getSimpleName() + ", hired for " + orchestra.hire(trumpeter2) + " euros");
		
		// The next 2 lines will throw "AlreadyHiredMusician" exception
		orchestra.hire(trumpeter1);
		orchestra.hire(trumpeter2);
		
		System.out.println("\nThese are the " + orchestra.getName() + " participants:");
		System.out.println(orchestra.toString());
		
		orchestra.act();
		
		System.out.println("\nSpent on " + orchestra.getName() + " participant's salaries: " + orchestra.getFee());
	}
}
