package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ss.week3.Format;

public class Bill {
	
	public interface Item {
		public double getAmount();
	}
	
	public List<Bill.Item> items = new ArrayList<Bill.Item>();
	public double amount;
	PrintStream theOutStream;
	
	public Bill(java.io.PrintStream theOutStream) {
		this.theOutStream = theOutStream;
		
	}
	
	public void newItem(Bill.Item item) {
		items.add(item);
		amount += item.getAmount();
		if (theOutStream != null) {
			theOutStream.println(Format.printLine(item.toString(), item.getAmount()));
		}
	}
	public void close() {
		theOutStream.println(Format.printLine("Totale kosten", amount));
	}
	
	public double getSum() {
		return amount;
	}
	
}
