package pl.modules;

import org.junit.Assert;
import org.junit.Test;

import pl.modules.REGON;

public class REGONTest {
	private static String shortWages = "89234567";
	private static String longWages = "2485097361248";
	private static String generatedREGON = null;

	@Test
	public void testGenerateShortREGON() {
		REGON regon = new REGON();
		generatedREGON = regon.generateShortREGON();
		boolean isValid = false;

		if (generatedREGON.length() == 9 && isCheckSumValid(shortWages)) {
			isValid = true;
		}

		Assert.assertEquals(true, isValid);
	}

	@Test
	public void testGenerateLongREGON() {
		REGON regon = new REGON();
		generatedREGON = regon.generateLongREGON();
		boolean isValid = false;

		if (generatedREGON.length() == 14 && isCheckSumValid(longWages)) {
			isValid = true;
		}

		Assert.assertEquals(true, isValid);
	}
		
	private boolean isCheckSumValid(String wages) {
		boolean isValid = false;
		int lastPosition = generatedREGON.length() - 1;
		int sum = 0;

		for (int i = 0; i < lastPosition; ++i) {
			int wage = Character.getNumericValue(wages.charAt(i));
			int number = Character.getNumericValue(generatedREGON.charAt(i));
			sum += wage * number;
		}

		sum %= 11;
		if ( sum == 10 ) {
			sum = 0;
		}

		int checksum = Character.getNumericValue(generatedREGON.charAt(lastPosition));
		if (checksum == sum) {
			isValid = true;
		}

		return isValid;
	}
}
