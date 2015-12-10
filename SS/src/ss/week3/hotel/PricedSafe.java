package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends Safe implements Item {
	
	double price;
	public PricedSafe(double price) {
		this.price = price;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return "PricedSafe " + price;
	}

}
