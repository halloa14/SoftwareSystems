package ss.week3.pw;

public class StrongChecker implements Checker {
	
	public boolean acceptable(String suggestion) {
		
		if (!(suggestion.contains(" ") || suggestion.length() < 7)) {
			
				Character fchar = suggestion.charAt(0);
				Character lchar = suggestion.charAt(suggestion.length() - 1);
				return (fchar.isLetter() && isDigit(lchar));

			
		}
		else {return false;}
		
		
	}

}
