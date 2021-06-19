package packlightbulb;

/**
 * Represents a LED light bulb.
 * @author Oihan Irastorza
 * @version 1
 */
public class Led extends NonIncandescent implements security {
	
	private String color;
	private double tightness;

	/**
	 * Led class constructor. Calls to NonIncandescent superclass constructor,
	 * and initializes color and tightness attributes.
	 * @param ID light bulb identifier
	 * @param watts light bulb rated power (W)
	 * @param lumens light bulb maximum brightness (Lm)
	 * @param color led color (orange, cyan, blue or red)
	 * @param tightness led tightness percentage.
	 */
	public Led(String ID, double watts, double lumens, String color, double tightness) {
		super(ID, watts, lumens, false);
		this.color = color;
		this.tightness = tightness;
	}
	
	/**
	 * The currentBrightness value for LEDS varies depending on the color.
	 */
	@Override
	public double currentBrightness() {
		double multiplier;
		switch (color) {
			case "orange":
				multiplier = 1.29;
				break;
			case "cyan":
				multiplier = 1.5;
				break;
			case "blue":
				multiplier = 1.31;
				break;
			case "red":
				multiplier = 1.15;
				break;
			default:
				multiplier = 1;
				break;
		}
		return Math.min(super.currentBrightness() * multiplier, getLumens());
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Color=" + color + ", Tightness=" + tightness + ", Security=" + securityLevel();
	}

	/**
	 * The security level for Leds its calculated by multiplying the tightness divided by 100, by 3.
	 */
	@Override
	public double securityLevel() {
		return (tightness/100) * 3;
	}

}
