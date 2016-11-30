package pl.modules;

import org.junit.Assert;
import org.junit.Test;

public class NameTest {

	@Test
	public void testGetMaleName() {
		Name name = new Name();
		String maleName = name.getMaleName();
		
		boolean isValid = (maleName.length() > 0) ? true : false;
		Assert.assertEquals(true, isValid);
	}

	@Test
	public void testGetFemaleName() {
		Name name = new Name();
		String femaleName = name.getFemaleName();
		
		boolean isValid = (femaleName.length() > 0) ? true : false;
		Assert.assertEquals(true, isValid);
	}

}
