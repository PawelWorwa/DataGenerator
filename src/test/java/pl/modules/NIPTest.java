package pl.modules;

import org.junit.Assert;
import org.junit.Test;

import pl.modules.NIP;

public class NIPTest {
	private static String weights = "657234567";
	private static String generatedNIP = null;

	@Test
	public void testGetNIP() {
		NIP nip = new NIP();
		generatedNIP = nip.generateNIP();
		boolean isValid = false;

		if (generatedNIP.length() == 10 && isCheckSumValid()) {
			isValid = true;
		}

		Assert.assertEquals(true, isValid);
	}
	
	private boolean isCheckSumValid() {
		boolean isValid = false;
		int sum = 0;
		
		for (int i = 0; i < generatedNIP.length() - 1; ++i) {
			int wage = Character.getNumericValue(weights.charAt(i));
			int number = Character.getNumericValue(generatedNIP.charAt(i));
			sum += wage * number;
		}

		sum %= 11;
		
		int lastPosition = generatedNIP.length() - 1;
		int checksum =  Character.getNumericValue(generatedNIP.charAt(lastPosition));
		if (checksum == sum) {
			isValid =  true;
		}
		
		return isValid;
	}

}
