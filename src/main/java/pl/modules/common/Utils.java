package pl.modules.common;

import java.util.concurrent.ThreadLocalRandom;

final public class Utils {
	public static String createRandomNumbers(int length) {
		String numbers = "";

		for (int i = 0; i < length; ++i) {
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 9);
			numbers += Integer.toString(randomNumber);
		}

		return numbers;
	}

	public static int calculateSum(String numbers, String wages) {
		int sum = 0;

		for (int i = 0; i < numbers.length(); ++i) {
			int wage = Character.getNumericValue(wages.charAt(i));
			int number = Character.getNumericValue(numbers.charAt(i));
			sum += wage * number;
		}

		return sum;
	}

}
