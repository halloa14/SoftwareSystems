package ss.week3.hotel;

public class Safe {
	
	private Password pass = new Password();
	private boolean isactive = false;
	private boolean isopen = false;
	
	//Constructor die niks speciaals doet. (Eigenlijk doet java dit zelf)
	public Safe() {
		
	}

	// Activeert de kluis.
	//@ requires ww != null;
	public void activate(String ww) {
		assert ww != null; //Alleen nuttig tijdens ontwikkeling (Programmeurs check)
		if (getPassword().testWord(ww)) {
			isactive = true;
		}
	}
	
	// Deactiveert de kluis.
	//@ ensures isActive() == false;
	public void deactivate() {
		isactive = false;
	}
	
	// Opent de kluis wanneer dat mogelijk is (kluis moet actief zijn)
	public void open(String ww) {
		if (isActive() && getPassword().testWord(ww)) {
			isopen = true;
		}
	}
	
	// Sluit de kluis.
	public void close() {
		isopen = false;
	}
	
	// Geeft aan of de kluis actief is.
	//@ pure
	public boolean isActive() {
		return isactive;
	}
	
	// Geeft aan of de kluis open is.
	//@ pure
	public boolean isOpen() {
		return isopen;
	}
	
	// Haalt het wachtwoord op.
	//@ pure
	public Password getPassword() {
		return pass;
	}
	
}
