package ss.week3.hotel;

public class Item implements ss.week3.hotel.Bill.Item {
	
	public String name;
	public double amount;
	
	public Item(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	

	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return name;
	}

}
