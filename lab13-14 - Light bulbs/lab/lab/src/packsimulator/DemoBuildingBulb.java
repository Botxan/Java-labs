package packsimulator;

import packlightbulb.*;
import packbuilding.*;

/**
 * Building simulator. Used for testing the classes in packbuilding
 * and packlightbulb packages
 * @author Oihan
 * @version 1
 */
public class DemoBuildingBulb {
	
	/**
	 * Main method
	 * @param args No parameters required
	 */
	public static void main(String[] args) {	
		// Create building instance
		Building building = new Building();
		
		// Create light bulb instances
		LightBulb lighBulb1 = new LightBulb("Lightbulb1", 58, 755);
		Fluorescent fluorescent1 = new Fluorescent("Fluorescent1", 55, 750, "DEOS ST171");
		Adjustable adjustable1 = new Adjustable("Adjustable1", 60, 780);
		Incandescent incadescent1 = new Incandescent("Incandescent1", 70, 865);
		NonIncandescent nonIncandescent1 = new NonIncandescent("NonIncandescent1", 50, 680, true);
		Halogen halogen1 = new Halogen("Halogen1", 90, 950);
		Led led1 = new Led("Led1", 97, 950, "red", 50);
		Led led2 = new Led("Led2", 97, 950, "orange", 70);
		
		// Add light bulbs to the building
		building.addLightBulb(lighBulb1);
		building.addLightBulb(fluorescent1);
		building.addLightBulb(adjustable1);
		building.addLightBulb(incadescent1);
		building.addLightBulb(nonIncandescent1);
		building.addLightBulb(halogen1);
		building.addLightBulb(led1);
		building.addLightBulb(led2);
		
		// This block will not raise any exception since
		// every bulb that we are passing has been created previsouly above
		try {
			building.turnOnLightBulb(fluorescent1.getID());
			building.turnOnLightBulb(incadescent1.getID());
			building.turnOnLightBulb(led1.getID());
			building.turnOnLightBulb(led2.getID());
		} catch (UnknownIdentifierException e) {
			System.out.println("(Unexpected) There is no light bulb in the building that matches the passed id");
		} catch (AlreadyOnException e) {
			System.out.println("(Unexpected) The light bulb is already on");
		}
		
		System.out.println("Current and total consumption of the bulbs:");
		System.out.println("Total consumption of the bulbs on: " + building.currentConsumption());
		System.out.println("Maximum consumption of the building: " + building.maximumConsumption());
		
		System.out.println("\nRaising exceptions:");
		// The next block will catch unknownIdentifierException
		try {
			System.out.println("\nTurning on a light bulb that is already on...");
			building.turnOnLightBulb("unknownId");
		}  catch (UnknownIdentifierException e) {
			System.out.println(e.getMessage());
		} catch (AlreadyOnException e) {
		}
		
		// The next block will catch AlreadyOnException
		try {
			System.out.println("\nTrying to turn on a light bulb that doesn't match any ID...");
			building.turnOnLightBulb(fluorescent1.getID());
		}  catch (UnknownIdentifierException e) {
			System.out.println("(Unexpected) " + e.getMessage());
		} catch (AlreadyOnException e) {
		}
		
		building.sort();
		System.out.println("\nList of light bulbs ordered by ID:");
		building.printBulbs();
		
		System.out.println("\nList of light bulbs that can be placed in wet places: ");
		building.printWetPlaceBulbs();
	}
}
