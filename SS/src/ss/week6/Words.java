package ss.week6;

import java.util.Scanner;

public class Words {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Maak eens een mooie zin.");
		while (scanner.hasNext()) { 
			System.out.println(scanner.next());
		}
	}	
}
