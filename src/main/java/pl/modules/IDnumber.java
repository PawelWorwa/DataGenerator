package pl.modules;

import java.util.concurrent.ThreadLocalRandom;

import pl.modules.common.Utils;

public final class IDnumber {
	private static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String weights = "73173173";

	public String generateIDnumber() {
		String IdPrefix = generatePrefix();
		String IdSurfix = Utils.createRandomNumbers(5);

		int sum = calculatePrefixSum(IdPrefix);
		sum += calculateSurfixSum(IdSurfix);
		sum %= 10;

		String checksum = Integer.toString(sum);
		String IdNumber = IdPrefix + checksum + IdSurfix;

		return IdNumber;
	}

	private int calculatePrefixSum(String IdPrefix) {
		int sum = 0;
		for (int i = 0; i < 3; ++i) {
			int wage = Character.getNumericValue(weights.charAt(i));
			char letter = IdPrefix.charAt(i);
			int index = getLetterIndex(letter);
			sum += wage * (index + 10);
		}

		return sum;
	}

	private int getLetterIndex(char letter) {
		int index = 0;
		for (int i = 0; i < letters.length(); ++i) {
			if (letters.charAt(i) == letter) {
				index = i;
				break;
			}
		}
		
		return index;
	}

	private int calculateSurfixSum(String IdSurfix) {
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			int wage = Character.getNumericValue(weights.charAt(i + 3));
			int number = Character.getNumericValue(IdSurfix.charAt(i));
			sum += wage * number;
		}

		return sum;
	}

	private String generatePrefix() {
		String IdPrefix = "";
		for (int i = 0; i < 3; ++i) {
			int index = ThreadLocalRandom.current().nextInt(0, letters.length() - 1);
			char letter = letters.charAt(index);
			IdPrefix += letter;
		}

		return IdPrefix;
	}
}
