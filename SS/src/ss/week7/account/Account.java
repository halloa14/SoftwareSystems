package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	Lock lock = new ReentrantLock();
	final Condition sufficient  = lock.newCondition(); 

	public void transaction(double amount) {
		while (balance - amount < -1000) {
			try {
				sufficient.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		lock.lock();
		balance = balance + amount;
		sufficient.signal();
		lock.unlock();
	}
	public double getBalance() {
		return balance;

	}
}
