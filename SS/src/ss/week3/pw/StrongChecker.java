package ss.week3.pw;

public class StrongChecker extends BasicChecker implements Checker {
	
	public static final String INITIAL = "banaan1";
	
	@Override
	public boolean acceptable(String suggestion) {
		Character fchar = suggestion.charAt(0);
		Character lchar = suggestion.charAt(suggestion.length() - 1);
		return super.acceptable(suggestion) && 
						(Character.isLetter(fchar) && Character.isDigit(lchar));
			
		
	}
	
	@Override
	public String generatePassword() {
		return INITIAL;
	}

}
