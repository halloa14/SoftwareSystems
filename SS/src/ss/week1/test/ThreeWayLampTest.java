package ss.week1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week1.ThreeWayLamp;

public class ThreeWayLampTest {
	
	public ThreeWayLamp lamp;
	
	@Before
	public void setUp() throws Exception {
		lamp = new ThreeWayLamp();
	}

	@Test
	public void test() {
		int status = lamp.getStatus();
		assertEquals("", 0, status);
		lamp.switchSetting();
		status = lamp.getStatus();
		assertEquals("", 1, status);
		
	}

}
