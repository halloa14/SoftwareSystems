package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		
		Account account = new Account();
		MyThread thread1 = new MyThread(5, 18, account);
		MyThread thread2 = new MyThread(-5, 18, account);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(account.getBalance());
	}

}
