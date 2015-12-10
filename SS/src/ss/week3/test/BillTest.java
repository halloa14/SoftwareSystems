package ss.week3.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Item;

public class BillTest {
	
	Bill bill;
	Item drank;
	Item eten;
	Item schoonmaak;

	@Before
	public void setUp() throws Exception {
		bill = new Bill(System.out);
		drank = new Item("drank", 2.20);
		eten = new Item("Eten", 7.30);
		schoonmaak = new Item("Schoonmaak kosten", 25.50);
	}

	@Test
	public void test() {
		bill.newItem(drank);
		bill.newItem(drank);
		bill.newItem(eten);
		bill.newItem(schoonmaak);
		bill.close();
		
	}

}
