package pl.modules;

import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import pl.modules.common.Utils;

final public class PESEL {
	private static String wages = "1379137913";

	public String generateFemalePesel(int age) {
		String PESEL = GenerateIncopletePesel( age);
		PESEL += getFemaleOrdinalNumber();
		
		String checksum = calculateChecksum(PESEL);
		PESEL += checksum;

		return PESEL;
	}
	
	public String generateMalePesel(int age) {
		String PESEL = GenerateIncopletePesel( age);
		PESEL += getMaleOrdinalNumber();
		
		String checksum = calculateChecksum(PESEL);
		PESEL += checksum;

		return PESEL;
	}
	
	public String generatePesel(int age) {
		int random = ThreadLocalRandom.current().nextInt(1, 100);
		return ( random <= 50 ) ? generateFemalePesel( age ) : generateMalePesel( age );
	}
	
	private String GenerateIncopletePesel(int age) {
		Calendar randomBirthDate = randomBirthDate(age);
		String year = getBirthYear(randomBirthDate);
		String month = getBirthMonth(randomBirthDate);
		String day = getBirthDay(randomBirthDate);
		String numbers = Utils.createRandomNumbers(3);
		
		String PESEL = year + month + day + numbers;
		return PESEL;
	}
	
	private Calendar randomBirthDate(int age) {
		int birthYear = Calendar.getInstance().get(Calendar.YEAR) - age;
		int dayOfYear = ThreadLocalRandom.current().nextInt(1, 365);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, birthYear);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

		return calendar;
	}

	private int getMonthAdjustedValue(int year) {
		int adjustValue = 0;

		if (year >= 1800 && year <= 1899) {
			adjustValue = 80;

		} else if (year >= 2000 && year <= 2099) {
			adjustValue = 20;

		} else if (year >= 2100 && year <= 2199) {
			adjustValue = 40;

		} else if (year >= 2200 && year <= 2299) {
			adjustValue = 60;
		}

		return adjustValue;
	}

	private String getBirthYear(Calendar randomBirthDate) {
		int year = randomBirthDate.get(Calendar.YEAR);
		String yearStr = Integer.toString(year).substring(2);
		return yearStr;
	}

	private String getBirthMonth(Calendar randomBirthDate) {
		int year = randomBirthDate.get(Calendar.YEAR);
		int monthAdjuster = getMonthAdjustedValue(year);
		int month = monthAdjuster + randomBirthDate.get(Calendar.MONTH) + 1; // months are indexed from 0

		String monthStr = Integer.toString(month);
		if (monthStr.length() < 2) {
			monthStr = "0" + monthStr;
		}

		return monthStr;
	}

	private String getBirthDay(Calendar randomBirthDate) {
		int day = randomBirthDate.get(Calendar.DAY_OF_MONTH);

		String dayStr = Integer.toString(day);
		if (dayStr.length() < 2) {
			dayStr = "0" + dayStr;
		}

		return dayStr;
	}

	private String getFemaleOrdinalNumber() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
		randomNum = randomNum / 2 * 2;
		if (randomNum == 10) {
			randomNum = 0;
		}

		return Integer.toString(randomNum);
	}

	private String getMaleOrdinalNumber() {
		int randomNum = 0;
		while (true) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 10);
			if (randomNum % 2 != 0) {
				break;
			}
		}

		return Integer.toString(randomNum);
	}

	private String calculateChecksum(String PESEL) {
		int sum = Utils.calculateSum(PESEL, wages);
		sum %= 10;
		sum = 10 - sum;
		sum %= 10;

		String checksum = Integer.toString(sum);
		return checksum;
	}

}