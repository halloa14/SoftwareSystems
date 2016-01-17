package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value = 0;
	private int set = 0;

	@Override
	public synchronized void setValue(int val) {
		if (set == 1) {
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		set = 1;
		this.value = val;
		notify();



	}

	@Override
	public synchronized int getValue() {
		if (set == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		set = 0;
		notify();
		return value;
		
		

		

	}

}
