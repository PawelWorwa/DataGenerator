package pl.modules;

import org.junit.Assert;
import org.junit.Test;

public class SurnameTest {

	@Test
	public void testGetSurename() {
		Surname surname = new Surname();
		String name = surname.getSurename();
		
		boolean isValid = (name.length() > 0) ? true : false;
		Assert.assertEquals(true, isValid);
	}

}
