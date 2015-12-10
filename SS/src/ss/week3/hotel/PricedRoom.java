package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedRoom extends Room implements Item {
	
	double price;
	public PricedRoom(int rnumber, double rprice, double sp) {
		super(rnumber, new PricedSafe(sp));
		this.price = rprice;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	@Override
	public String toString() {
		return "" + price + ((PricedSafe) getSafe()).getAmount();
	}

}
