package ss.week7.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	Lock lock = new ReentrantLock();

	public synchronized void transaction(double amount) {
		balance = balance + amount;
	}
	public double getBalance() {
		return balance;

	}
}
