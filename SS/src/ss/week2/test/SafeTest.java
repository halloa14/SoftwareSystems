package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ss.week1.hotel.Password;
import ss.week2.hotel.Safe;

public class SafeTest {
	
	Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe();
	}

	@Test
	public void correctPasswordActivateTest() {
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());
	}
	
	@Test
	public void incorrectPasswordActivateTest() {
		safe.activate(Password.INITIAL + "Onzin");
		assertFalse(safe.isActive());
	}
	
	@Test
	public void deactivateTest() {
		safe.activate(Password.INITIAL);
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	
	@Test
	public void openWhileActive() {
		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		assertTrue(safe.isOpen());
	}
	
	@Test
	public void openWhileNotActive() {
		safe.open(Password.INITIAL);
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void closeWhileOpen () {
		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		safe.close();
		assertFalse(safe.isOpen());
	}

}
