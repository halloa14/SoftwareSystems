package ss.week3.pw;

public class BasicChecker implements Checker {
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ") || suggestion.length() < 7);
	}
	
	

}
