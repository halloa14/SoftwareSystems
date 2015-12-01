package ss.week3.hotel;

import java.util.ArrayList;

public class Hotel {
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel("Banaan hotel", 4);
		hotel.checkIn(Password.INITIAL, "Ernst");
		hotel.checkIn(Password.INITIAL, "Bobbie");
		hotel.checkIn(Password.INITIAL, "Kim");
		System.out.println(hotel.toString());
	}
	private Password hpass;
	private ArrayList<Room> rooms;
	private String naam;
	
	public Hotel(String name, int aantalkamers) {
		hpass = new Password();
		rooms = new ArrayList<Room>();
		naam = name;
		/* For loop zorgt ervoor dat er het ingegeven aantal kamers wordt aangemaakt
		in de ArrayList rooms. De kamers krijgen een nummer, beginnend vanaf 1 */
		for (int i = 0; i < aantalkamers; i++) {
			Room room = new Room(i + 1);
			rooms.add(room);
		}
	}
	
	public Room checkIn(String pass, String name) {
		if (!(hpass.testWord(pass) && getFreeRoom() != null && getRoom(name) == null)) {
			return null;
		}
		Room room = getFreeRoom();
		room.setGuest(new Guest(name));
		return room;
	}
	
	public void checkOut(String guest) {
		if (getRoom(guest) != null) {
			Room room = getRoom(guest);
			room.setGuest(null);
			room.getSafe().deactivate();
		}
	} 
	
	public Room getFreeRoom() {
		for (int i = 0; i < rooms.size(); i++) {
			Room room = rooms.get(i);
			if (room.getGuest() == null) {
				return room;
			}
		}
		return null;
		
	}
	
	public Room getRoom(String name) {
		for (Room r : rooms) {
			if (r.getGuest() != null && r.getGuest().getName().equals(name)) {
				return r;
			}
		}
		return null;
		
		
	}
	
	public Password getPassword() {
		return hpass;
	}
	
	public String toString() {
		String result = "Hotel: " + naam + " bevat de volgende kamers: \n";
		for (Room r : rooms) {
			result += r.toString() + " ";
			if (r.getGuest() != null) {
				result += r.getGuest().getName();
			} else {
				result += "Kamer is vrij";
			}
			if (r.getSafe().isActive()) {
				result += " Kluis is actief \n";
			} else {
				result += " Kluis is inactief \n";
			}
		}
		return result;
	}

}
