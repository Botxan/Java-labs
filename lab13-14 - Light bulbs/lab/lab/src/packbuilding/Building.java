package packbuilding;

import packlightbulb.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a set of light bulbs in a building.
 * @author Oihan Irastorza
 * @version 1
 */
public class Building {
	ArrayList<LightBulb> lightBulbList;
	
	/**
	 * Building class constructor. Initializes the ligh bulb ArrayList.
	 */
	public Building() {
		lightBulbList = new ArrayList<LightBulb>();
	}
	
	/**
	 * Tries to turn on the light bulb with the identifier passed by parameter.
	 * @param ID light bulb identifier
	 * @throws UnknownIdentifierException if the ID passed by parameter does not
	 * match any ID in the light bulb list
	 * @throws AlreadyOnException if the light bulb is already on
	 */
	public void turnOnLightBulb(String ID) throws UnknownIdentifierException, AlreadyOnException{
		obtainLightBulb(ID).turnOn();
	}
	
	/**
	 * Tries to turn off the light bulb with the identifier passed by parameter.
	 * @param ID light bulb identifier
	 * @throws UnknownIdentifierException if the ID passed by parameter does not
	 * match any ID in the light bulb list
	 * @throws AlreadyOffException if the light bulb is already on
	 */
	public void turnOffLightBulb(String ID) throws UnknownIdentifierException, AlreadyOffException{
		obtainLightBulb(ID).turnOff();
	}
	
	/**
	 * Prints on standard output the information of every light bulb in the array.
	 */
	public void printBulbs() {
		for (LightBulb lightBulb: lightBulbList) {
			System.out.println(lightBulb.toString());
		}
	}
	
	/**
	 * Returns the light bulb with the ID passed by parameter
	 * @param ID lightbulb identifier
	 * @return the light bulb that matches the ID passed by parameter
	 * @throws UnknownIdentifierException if the ID passed by parameter does not
	 * match any ID in the light bulb list
	 */
	public LightBulb obtainLightBulb(String ID) throws UnknownIdentifierException {
		int index = lightBulbList.indexOf(new LightBulb(ID, 0.0, 0.0));
		if (index == -1) throw new UnknownIdentifierException("There is no light bulb with the selected identifier");
		return lightBulbList.get(index);
	}
	
	/**
	 * Returns the sum of energy consumption of all the light bulbs in the building.
	 * @return the sum of energy consumption of all the light bulbs in the building
	 */
	public double currentConsumption() {
		double consumption = 0;
		for (LightBulb lightBulb: lightBulbList)
			if (lightBulb.isOn()) consumption += lightBulb.getWatts();
		return consumption;
	}
	
	/**
	 * Returns the sum of maximum energy consumption of all light bulbs in the building
	 * by turning on every light bulb.
	 * @return the sum of maximum energy consumption of all light bulbs in the building
	 */
	public double maximumConsumption() {
		double consumption = 0;
		for (LightBulb lightBulb: lightBulbList) {
			try {
				turnOnLightBulb(lightBulb.getID());
			} catch (AlreadyOnException | UnknownIdentifierException e) {}
			consumption += lightBulb.getWatts();
		}
		
		return consumption;
	}
	
	/**
	 * Adds the light bulb passed by parameter to the light bulb list.
	 * @param lightbulb the light bulb that is going to be added to the light bulb list
	 */
	public void addLightBulb(LightBulb lightbulb) {
		if (lightBulbList.contains(lightbulb)) lightBulbList.remove(lightbulb);
		lightBulbList.add(lightbulb);
	}
	
	/**
	 * Sorts the light bulb list by bulb identifier.
	 */
	public void sort() {
		Collections.sort(lightBulbList);
	}
	
	/**
	 * Prints every light bulb that can be placed in wet places.
	 */
	public void printWetPlaceBulbs() {
		for (LightBulb lightBulb: lightBulbList) {
			if (lightBulb instanceof security) System.out.println(lightBulb.toString());
		}
	}
}
