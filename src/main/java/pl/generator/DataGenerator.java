package pl.generator;

import pl.modules.IDnumber;
import pl.modules.NIP;
import pl.modules.Name;
import pl.modules.PESEL;
import pl.modules.REGON;
import pl.modules.Surname;

final public class DataGenerator {
	private DataGenerator () {
	}

	public static String generateNIP() {
		NIP nip = new NIP();
		return nip.generateNIP();
	}

	public static String generateShortRegon() {
		REGON regon = new REGON();
		return regon.generateShortREGON();
	}

	public static String generateLongRegon() {
		REGON regon = new REGON();
		return regon.generateLongREGON();
	}

	public static String generateCardIDnumber() {
		IDnumber id = new IDnumber();
		return id.generateIDnumber();
	}

	public static String generateFemalePesel(int age) {
		PESEL pesel = new PESEL();
		return pesel.generateFemalePesel(age);
	}

	public static String generateMalePesel(int age) {
		PESEL pesel = new PESEL();
		return pesel.generateMalePesel(age);
	}

	public static String generatePesel(int age) {
		PESEL pesel = new PESEL();
		return pesel.generatePesel(age);
	}
	
	public static String generateSurname() {
		Surname surname = new Surname();
		return surname.getSurename();
	}
	
	public static String generateFemaleName() {
		Name name = new Name();
		return name.getFemaleName();
	}
	
	public static String generateMaleName() {
		Name name = new Name();
		return name.getMaleName();
	}
}
