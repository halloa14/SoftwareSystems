package ss.week1;

public class ThreeWayLamp {

	public static void main(String[] args) {
	}

	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MED = 2;
	public static final int HIGH = 3;
		
	public int status = 0;
	
	
	public void switchSetting() {
		this.status = (status + 1) % 4;
	}
	
	public int getStatus() {
		return status;
	}

}
