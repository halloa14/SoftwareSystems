package ss.week3.hotel;
/**
 * 
 * @author Sander
 * @version 1.0
 */
public class Guest {
	
	private String name;
	private Room room;
	private boolean cistatus; 
	
	public Guest(String name) {
		this.name = name;
		
	}
	/**
	 * Wat algemeen commentaar.
	 * @return Naam van de gast
	 */
	public String getName() {
		return name;
	}
	
	public Room getRoom() {
		return room;
	}
	/**
	 * 
	 * @param r kamerobject om in te checken
	 * @return returnd of het gelukt is.
	 */
	public boolean checkin(Room r) {
		if (r.getGuest() == null) {
			r.setGuest(this);
			this.room = r;
			return true;
		} else {
			return false; 
		}
		
	}
	/**
	 * Geeft het kamerobject weer vrij voor een nieuwe gast.
	 * @return returnd of het gelukt is.
	 */
	public boolean checkout() {
		if (room == null) {
			return false;
		} else {
			room.setGuest(null);
			room = null;
			return true;
		}
	}
	
	public String toString() {
		return "Guest: " + name;
	}

}
