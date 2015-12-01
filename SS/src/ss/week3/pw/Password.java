package ss.week3.pw;

public class Password {
	
	Checker checker;
	String factoryPassword;
	private String pass;
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = checker.generatePassword();
		pass = checker.generatePassword();
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	public boolean setWord(String oldp, String newp) {
		if (oldp.equals(pass) && checker.acceptable(newp)) {
			pass = newp;
			return true;
		}
		return false;
	}
	
	public boolean testWord(String test) {
		return test.equals(pass);
	}

	public Checker getChecker() {
		return checker;
	}

	public String getFactoryPassword() {
		return factoryPassword;
	}
	
}
