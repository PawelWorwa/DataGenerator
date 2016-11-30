package pl.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Surname {
	private List<String> surnames = new ArrayList<String>();
	
	public Surname() {
		prepareSurenames();
	}
	
	public String getSurename() {
		int max = surnames.size() - 1;
		int random = ThreadLocalRandom.current().nextInt(0, max);
		String surename = surnames.get(random);
		return surename;
	}
	
	private void prepareSurenames() {
		surnames.add("Nowak");
		surnames.add("Kowalski");
		surnames.add("Wiśniewski");
		surnames.add("Dąbrowski");
		surnames.add("Lewandowski");
		surnames.add("Wójcik");
		surnames.add("Kamiński");
		surnames.add("Kowalczyk");
		surnames.add("Zieliński");
		surnames.add("Szymański");
		surnames.add("Woźniak");
		surnames.add("Kozłowski");
		surnames.add("Jankowski");
		surnames.add("Wojciechowski");
		surnames.add("Kwiatkowski");
		surnames.add("Kaczmarek");
		surnames.add("Mazur");
		surnames.add("Krawczyk");
		surnames.add("Piotrowski");
		surnames.add("Grabowski");
		surnames.add("Nowakowski");
		surnames.add("Pawłowski");
		surnames.add("Michalski");
		surnames.add("Nowicki");
		surnames.add("Adamczyk");
		surnames.add("Dudek");
		surnames.add("Zając");
		surnames.add("Wieczorek");
		surnames.add("Jabłoński");
		surnames.add("Król");
		surnames.add("Majewski");
		surnames.add("Olszewski");
		surnames.add("Jaworski");
		surnames.add("Wróbel");
		surnames.add("Malinowski");
		surnames.add("Pawlak");
		surnames.add("Witkowski");
		surnames.add("Walczak");
		surnames.add("Stępień");
		surnames.add("Górski");
		surnames.add("Rutkowski");
		surnames.add("Michalak");
		surnames.add("Sikora");
		surnames.add("Ostrowski");
		surnames.add("Baran");
		surnames.add("Duda");
		surnames.add("Szewczyk");
		surnames.add("Tomaszewski");
		surnames.add("Pietrzak");
		surnames.add("Marciniak");
		surnames.add("Wróblewski");
		surnames.add("Zalewski");
		surnames.add("Jakubowski");
		surnames.add("Jasiński");
		surnames.add("Zawadzki");
		surnames.add("Sadowski");
		surnames.add("Bąk");
		surnames.add("Chmielewski");
		surnames.add("Włodarczyk");
		surnames.add("Borkowski");
		surnames.add("Czarnecki");
		surnames.add("Sawicki");
		surnames.add("Sokołowski");
		surnames.add("Urbański");
		surnames.add("Kubiak");
		surnames.add("Maciejewski");
		surnames.add("Szczepański");
		surnames.add("Kucharski");
		surnames.add("Wilk");
		surnames.add("Kalinowski");
		surnames.add("Lis");
		surnames.add("Mazurek");
		surnames.add("Wysocki");
		surnames.add("Adamski");
		surnames.add("Kaźmierczak");
		surnames.add("Wasilewski");
		surnames.add("Sobczak");
		surnames.add("Czerwiński");
		surnames.add("Andrzejewski");
		surnames.add("Cieślak");
		surnames.add("Głowacki");
		surnames.add("Zakrzewski");
		surnames.add("Kołodziej");
		surnames.add("Sikorski");
		surnames.add("Krajewski");
		surnames.add("Gajewski");
		surnames.add("Szymczak");
		surnames.add("Szulc");
		surnames.add("Baranowski");
		surnames.add("Laskowski");
		surnames.add("Brzeziński");
		surnames.add("Makowski");
		surnames.add("Ziółkowski");
		surnames.add("Przybylski");
		surnames.add("Domański");
		surnames.add("Nowacki");
		surnames.add("Borowski");
		surnames.add("Błaszczyk");
		surnames.add("Chojnacki");
		surnames.add("Ciesielski");
	}
	
}
