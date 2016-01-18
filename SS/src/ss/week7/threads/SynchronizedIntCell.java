package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value = 0;
	private boolean set = false;

	@Override
	public synchronized void setValue(int val) {
		while (set) {
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		set = true;
		this.value = val;
		notify();



	}

	@Override
	public synchronized int getValue() {
		while (!set) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		set = false;
		int val2 = value;
		notify();
		return val2;
		
		

		

	}

}
