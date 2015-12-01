package ss.week3.pw;

public class TimedPassword extends Password {
	
	private long validUntil;
	private long validityTime;
	private long defaultValidityTime = 365 * 24 * 60 * 60 * 1000;

	public TimedPassword() {
		new TimedPassword(defaultValidityTime);
	}

	public TimedPassword(long validityTime) {
		super();
		this.validUntil = validityTime + System.currentTimeMillis();
		this.validityTime = validityTime;
		
		
	}
	@Override
	public boolean setWord(String oldp, String newp) {
		if (super.setWord(oldp, newp)) {
			validUntil = System.currentTimeMillis() + validityTime;
			return true;
		}
		
		return false;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > validUntil;
	}

}
