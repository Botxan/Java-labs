package packlightbulb;

/**
 * Represents a light bulb in general. 
 * @author Oihan Irastorza
 * @version 1
 */
public class LightBulb implements Comparable<LightBulb> {
	private final String ID;
	private double watts;
	private double lumens;
	private boolean on;
	
	/**
	 * LightBulb class constructor. Initializes ID, watts and lumen, and on attributes.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 */
	public LightBulb(String ID, double watts, double lumens) {
		this.ID = ID;
		this.watts = watts;
		this.lumens = lumens;
		on = false;
	}
	
	/**
	 * Getter for ID attribute.
	 * @return lightbulb identifier
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Getter for watts attribute.
	 * @return light bulb rated power (W)
	 */
	public double getWatts() {
		return watts;
	}
	
	/**
	 * Getter for lumens attribute.
	 * @return light bulb maximum brightness (Lm).
	 */
	public double getLumens() {
		return lumens;
	}
	
	/**
	 * Getter for on attribute
	 * @return true if the light bulb is on. Otherwise, returns false.
	 */
	public boolean isOn() {
		return on;
	}
	
	/**
	 * Setter for watts atribute
	 * @param watts light bulb rated power (W)
	 */
	public void setWatts(double watts) {
		this.watts = watts;
	}
	
	/**
	 * Setter for lumens attribute
	 * @param lumens maximum brightness (Lm)
	 */
	public void setLumens(double lumens) {
		this.lumens = lumens;
	}
	
	/**
	 * Turns on the light bulb.
	 * @throws AlreadyOnException if the light bulb is already on
	 */
	public void turnOn() throws AlreadyOnException {
		if (on) throw new AlreadyOnException("The lightbulb is already on.");
		on = true;
	}
	
	/**
	 * Turns off the light bulb.
	 * @throws AlreadyOffException if the light bulb is already off
	 */
	public void turnOff() throws AlreadyOffException {
		if (!on) throw new AlreadyOffException("The lightbulb is already off.");
		on = false;
	}
	
	/**
	 * Returns the efficacy of the light bulb, which is calculated by dividing
	 * the luminosity by the rated power.
	 * @return light bulb efficacy
	 */
	public double efficacy() {
		return watts == 0 ? 0 : lumens / watts;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + ID +", Power(W)=" + watts + ", Brightness(Lm)=" + lumens + ", On=" + on;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (this == obj) equals = true;
		else 
			if (obj == null) equals = false;
			else 
				if (!(obj instanceof LightBulb)) equals = false;
				else {
					LightBulb lightBulb = (LightBulb) obj;
					equals = this.ID.equals(lightBulb.getID());
				}
		return equals;
	}

	@Override
	public int compareTo(LightBulb lightbulb) {
		return ID.compareTo(lightbulb.getID());
	}
}
