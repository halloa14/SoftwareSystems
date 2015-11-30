package ss.week3.pw;

public class Password implements Checker {
	
	public static final String INITIAL = "Banaan123!";
	private String pass;
	
	public Password() {
		pass = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ") || suggestion.length() < 7);
		
	}
	
	public boolean setWord(String oldp, String newp) {
		if (oldp == pass && acceptable(newp)) {
			pass = newp;
			return true;
		}
		return false;
	}
	
	public boolean testWord(String test) {
		return test.equals(pass);
	}

}
