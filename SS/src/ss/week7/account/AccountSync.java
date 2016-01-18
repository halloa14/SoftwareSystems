package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		
		Account account = new Account();
		MyThread thread1 = new MyThread(5, 18, account);
		MyThread thread2 = new MyThread(-5, 18, account);
		thread1.start();
		thread2.start();
		System.out.println(account.getBalance());
	}

}
