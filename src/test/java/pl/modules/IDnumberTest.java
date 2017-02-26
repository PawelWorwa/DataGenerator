package pl.modules;

import org.junit.Assert;
import org.junit.Test;

public class IDnumberTest {
	private static String weights = "731173173"; // additional digit is for checksum
	private static String idNumber = "";
	
	@Test
	public void testGenerateIDnumber() {
		IDnumber id = new IDnumber();
		idNumber = id.generateIDnumber();
		boolean isValid = false;
		
		if (isValidLength() && validateCharacters() && isChecksumValid()) {
			isValid = true;
		}

		Assert.assertEquals(true, isValid);
	}

	private boolean isValidLength() {
		boolean isValid = false;
		if (idNumber.length() == 9) {
			isValid = true;
		}

		return isValid;
	}

	private boolean validateCharacters() {
		boolean isValid = false;
		if (isLettersOk() && isNumbersOk()) {
			isValid = true;
		}

		return isValid;
	}

	private boolean isLettersOk() {
		boolean isValid = false;
		for (int i = 0; i < 3; ++i) {
			if (Character.isLetter(idNumber.charAt(i))) {
				isValid = true;

			} else {
				isValid = false;
				break;
			}
		}

		return isValid;
	}

	private boolean isNumbersOk() {
		boolean isValid = false;
		for (int i = 0; i < 5; ++i) {
			if (Character.isDigit(idNumber.charAt(i + 3))) {
				isValid = true;

			} else {
				isValid = false;
				break;
			}
		}

		return isValid;
	}

	private boolean isChecksumValid() {
		boolean isValid = false;		
		
		int sum = calculatePrefixSum();
		sum += calculateSurfixSum();
		sum %= 10;
		
		int checksum =  Character.getNumericValue(idNumber.charAt(3));
		if ( sum == checksum ) {
			isValid = true;
		}
		
		return isValid;
	}
	
	private int calculatePrefixSum() {
		int sum = 0;
		for (int i = 0; i < 3; ++i) {
			int wage = Character.getNumericValue(weights.charAt(i));
			char letter = idNumber.charAt(i);
			int index = getLetterIndex(letter);
			sum += wage * (index + 10);
		}

		return sum;
	}

	private int getLetterIndex(char letter) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = 0;
		for (int i = 0; i < letters.length(); ++i) {
			if (letters.charAt(i) == letter) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	private int calculateSurfixSum() {
		int sum = 0;
		for (int i = 4; i < 9; ++i) {
			int wage = Character.getNumericValue(weights.charAt(i));
			int number = Character.getNumericValue(idNumber.charAt(i));
			sum += wage * number;
		}
		
		return sum;
	}
	
}
