package ss.week7.threads;

public class TestConsole extends Thread {
	
	String name;
	
	public TestConsole(String name) {
		this.name = name;
	}
	
	public void run() {
		sum();
	}
	
	public void sum() {
		int a; int b;
		a = Console.readInt("Thread " + name + ": " + "Enter first number..  ");
		b = Console.readInt("Thread " + name + ": " + "Enter Second number.. ");
		System.out.println("" + a + " + " + b + " = " + (a + b));
		 
	}
	
	public static void main(String[] args) {
		new TestConsole("A").start();
		new TestConsole("B").start();
	}
}

