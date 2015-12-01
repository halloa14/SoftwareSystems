package ss.week3.pw;

public class BasicChecker implements Checker {
	
	public static final String INITIAL = "banaan";
	
	public boolean acceptable(String suggestion) {
		return !suggestion.contains(" ") && suggestion.length() >= 6;
	}
	
	public String generatePassword() {
		return INITIAL;
	}
	

}
