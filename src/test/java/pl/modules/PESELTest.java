package pl.modules;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;

import pl.modules.common.Utils;

public class PESELTest {
	private static String weights = "1379137913";

	@Test
	public void testVeryOldLadyPesel() {
		PESEL pesel = new PESEL();
		String femalePESEL = pesel.generateFemalePesel(200);
		boolean isValid = validatePesel(femalePESEL);
		Assert.assertEquals(true, isValid);
	}

	@Test
	public void testMalePesel() {
		PESEL pesel = new PESEL();
		String malePESEL = pesel.generateMalePesel(10);
		boolean isValid = validatePesel(malePESEL);
		Assert.assertEquals(true, isValid);
	}

	@Test
	public void testRandomPesel() {
		int random = ThreadLocalRandom.current().nextInt(1, 200);
		PESEL pesel = new PESEL();
		String randomPESEL = pesel.generatePesel(random);
		boolean isValid = validatePesel(randomPESEL);
		Assert.assertEquals(true, isValid);
	}

	private String calculateChecksum(String peselWithoutChesksum) {
		int sum = Utils.calculateSum(peselWithoutChesksum, weights);
		sum %= 10;
		sum = 10 - sum;
		sum %= 10;

		return Integer.toString(sum);
	}

	private boolean validatePesel(String PESEL) {
		String peselWithoutChesksum = PESEL.substring(0, PESEL.length() - 1);
		String peselChecksum = PESEL.substring(PESEL.length() - 1, PESEL.length());
		String calculatedChecksum = calculateChecksum(peselWithoutChesksum);

		return calculatedChecksum.equals(peselChecksum) ? true : false;
	}

}
