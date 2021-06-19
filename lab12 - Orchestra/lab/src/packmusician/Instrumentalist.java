package packmusician;

/**
 * Reprents any musician that handles an instrument.
 * @author Oihan
 * @version 1
 */
public class Instrumentalist extends Musician {
	private String instrument;
	
	/**
	 * Instrumentalist class constructor. Initializes the instrument attribute
	 * and calls to the superclass constructor.
	 * @param name instrumentalist name
	 * @param instrument the instrument
	 */
	public Instrumentalist(String name, String instrument) {
		super(name);
		this.instrument = instrument;
	}
	
	/**
	 * Gettter for instrument.
	 * @return the instrument
	 */
	public String getInstrument() {
		return instrument;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", instrument=" + instrument; 
	}
}
