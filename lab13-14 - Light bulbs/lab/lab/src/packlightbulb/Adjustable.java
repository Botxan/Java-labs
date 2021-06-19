package packlightbulb;

/**
 * Represents an adjustable light bulb
 * @author Oihan Irastorza
 * @version 1
 */
public class Adjustable extends LightBulb {
	
	private int percentage;

	/**
	 * Adjustable class constructor. Calls to LightBulb superclass constructor,
	 * and initializes percentage attribute.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 */
	public Adjustable(String ID, double watts, double lumens) {
		super(ID, watts, lumens);
		percentage = 0;
	}
	
	/**
	 * Setter for percentage attribute. The percentage attribute represents
	 * the current power usage.
	 * @param percentage current power usage
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	/**
	 * Returns the current brightness of the adjustable light bulb, which is
	 * calculated by multiplying the luminosity with the current power usage.
	 * @return current brightness (Lm)
	 */
	public double currentBrightness() {
		return getLumens() * (percentage / 100);
	}
	
	@Override
	public void turnOn() throws AlreadyOnException {
		super.turnOn();
		percentage = 50;
	}
	
	@Override
	public void turnOff() throws AlreadyOffException {
		super.turnOff();
		percentage = 0;
	}
	
	@Override
	public double efficacy() {
		return isOn() ? (getWatts() == 0 ? 0: (currentBrightness() / (getWatts() * (percentage / 100)))) : super.efficacy();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Power percentage=" + percentage +
				", Current brightness=" + currentBrightness();
	}
}