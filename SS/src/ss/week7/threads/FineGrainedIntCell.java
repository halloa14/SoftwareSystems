package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FineGrainedIntCell implements IntCell {
	
	final Lock lock = new ReentrantLock();
	final Condition full  = lock.newCondition(); 
	final Condition empty = lock.newCondition(); 
	private int value = 0;
	private boolean set = false;

	@Override
	public void setValue(int val) {
		lock.lock();
		while (set) {
			try {
				empty.await();
				value = val;
				set = true;
				full.signal();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
	}

	@Override
	public int getValue() {
		lock.lock();
		while (!set) {
			try {
				full.await();
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
			
			empty.signal();
			return value;
		}
		
	}


