package ss.week3;


public class Format {
	

	public Format() {
	}
	
	public static String printLine(String text, double amount) {
		String text2 = text + ":";
		String fml = String.format("%1$-20s %2$10.2f", text2, amount);
		return fml;
	}
	
	public static void main(String[] args) {
		System.out.println(printLine("Drankjes", 2.30));
		System.out.println(printLine("Voedels", 220.50));
	}

}
