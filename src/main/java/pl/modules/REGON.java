package pl.modules;

import pl.modules.common.Utils;

final public class REGON {
	private static String shortWeights = "89234567";
	private static String longWeights  = "2485097361248";
	
	public String generateShortREGON() {
		String REGON = Utils.createRandomNumbers(8);
		int sum = Utils.calculateSum(REGON, shortWeights);
		int checksum = calculateChecksum(sum);
		REGON += checksum;
		
		return REGON;
	}
	
	public String generateLongREGON() {
		String REGON = Utils.createRandomNumbers(13);
		int sum = Utils.calculateSum(REGON, longWeights);
		int checksum = calculateChecksum(sum);
		REGON += checksum;
		
		return REGON;
	}
	
	private int calculateChecksum( int sum ) {
		int checksum = sum % 11;
		
		if ( checksum == 10 ) {
			checksum = 0;
		}
		
		return checksum;
	}
}
