package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	String name;
	public static ReentrantLock lock = new ReentrantLock();
	
	public TestSyncConsole(String name) {
		this.name = name;
	}
	
	public void run() {
		sum(name);
	}
	
	public static void sum(String name) {
		lock.lock();
		int a; int b;
		a = SyncConsole.readInt("Thread " + name + ": " + "Enter first number..  ");
		b = SyncConsole.readInt("Thread " + name + ": " + "Enter Second number.. ");
		System.out.println("" + a + " + " + b + " = " + (a + b));
		lock.unlock();
		 
	}
	
	public static void main(String[] args) {
		TestSyncConsole A = new TestSyncConsole("A");
		TestSyncConsole B = new TestSyncConsole("B");
		
		B.start();
		A.start();
	}
}

