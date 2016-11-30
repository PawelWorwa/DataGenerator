package pl.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import pl.modules.common.Utils;

final public class NIP {
	private List<Integer> officeCodes = new ArrayList<Integer>();
	private static String wages = "657234567";

	public NIP() {
		prepareOfficeCodes();
	}

	public String generateNIP() {
		while (true) {
			int officeCode = getRandomOfficeCode(); // first three digits
			String NIP = Integer.toString(officeCode); 
			NIP += Utils.createRandomNumbers(6);
			
			int sum = Utils.calculateSum(NIP, wages);
			int checksum = sum % 11;
			NIP += Integer.toString(checksum);
			
			// handle modulo 11 = 10 scenario
			if (NIP.length() == 10) {
				return NIP;
			}
		}// while
	}
	
	
	private int getRandomOfficeCode() {
		int maxSize = officeCodes.size() - 1;
		Integer randomIndex = ThreadLocalRandom.current().nextInt(0, maxSize);
		return officeCodes.get(randomIndex);
	}

	private void prepareOfficeCodes() {
		officeCodes.add(101); // Dolnośląski Urząd Skarbowy we Wrocławiu
		officeCodes.add(102); // Kujawsko-Pomorski Urząd Skarbowy w Bydgoszczy
		officeCodes.add(103); // Lubelski Urząd Skarbowy w Lublinie
		officeCodes.add(104); // Lubuski Urząd Skarbowy w Zielonej Górze
		officeCodes.add(105); // Łódzki Urząd Skarbowy w Łodzi
		officeCodes.add(106); // Małopolski Urząd Skarbowy w Krakowie
		officeCodes.add(107); // Pierwszy Mazowiecki Urząd Skarbowy w Warszawie
		officeCodes.add(108); // Drugi Mazowiecki Urząd Skarbowy w Warszawie
		officeCodes.add(109); // Trzeci Mazowiecki Urząd Skarbowy w Radomiu
		officeCodes.add(111); // Urząd Skarbowy Warszawa-Mokotów
		officeCodes.add(112); // Urząd Skarbowy Warszawa-Bemowo
		officeCodes.add(113); // Urząd Skarbowy Warszawa-Praga
		officeCodes.add(114); // Urząd Skarbowy Warszawa-Targówek
		officeCodes.add(115); // Pierwszy Urząd Skarbowy Warszawa-Śródmieście
		officeCodes.add(116); // Drugi Urząd Skarbowy Warszawa-Śródmieście
		officeCodes.add(117); // Urząd Skarbowy Warszawa-Wola
		officeCodes.add(118); // Urząd Skarbowy Warszawa-Bielany
		officeCodes.add(119); // Urząd Skarbowy w Grodzisku Mazowieckim
		officeCodes.add(121); // Urząd Skarbowy w Nowym Dworze Mazowieckim
		officeCodes.add(122); // Urząd Skarbowy w Otwocku
		officeCodes.add(123); // Urząd Skarbowy w Piasecznie
		officeCodes.add(124); // Urząd Skarbowy w Pruszkowie
		officeCodes.add(125); // Urząd Skarbowy w Wołominie
		officeCodes.add(126); // Urząd Skarbowy w Białej Podlaskiej
		officeCodes.add(127); // Urząd Skarbowy w Parczewie
		officeCodes.add(128); // Urząd Skarbowy w Radzyniu Podlaskim
		officeCodes.add(129); // Pierwszy Urząd Skarbowy w Białymstoku
		officeCodes.add(131); // Urząd Skarbowy w Bielsku Podlaskim
		officeCodes.add(132); // Urząd Skarbowy w Mońkach
		officeCodes.add(133); // Urząd Skarbowy w Siemiatyczach
		officeCodes.add(134); // Urząd Skarbowy w Sokółce
		officeCodes.add(135); // Pierwszy Urząd Skarbowy w Bielsku-Białej
		officeCodes.add(136); // Urząd Skarbowy w Cieszynie
		officeCodes.add(137); // Urząd Skarbowy w Oświęcimiu
		officeCodes.add(138); // Urząd Skarbowy w Suchej Beskidzkiej
		officeCodes.add(139); // Urząd Skarbowy w Wadowicach
		officeCodes.add(141); // Urząd Skarbowy w Żywcu
		officeCodes.add(142); // Pierwszy Urząd Skarbowy w Bydgoszczy
		officeCodes.add(143); // Urząd Skarbowy w Chojnicach
		officeCodes.add(144); // Urząd Skarbowy w Inowrocławiu
		officeCodes.add(145); // Urząd Skarbowy w Mogilnie
		officeCodes.add(146); // Urząd Skarbowy w Nakle nad Notecią
		officeCodes.add(147); // Urząd Skarbowy w Świeciu
		officeCodes.add(148); // Urząd Skarbowy w Tucholi
		officeCodes.add(149); // Urząd Skarbowy w Żninie
		officeCodes.add(151); // Urząd Skarbowy w Chełmie
		officeCodes.add(152); // Urząd Skarbowy w Krasnymstawie
		officeCodes.add(153); // Urząd Skarbowy we Włodawie
		officeCodes.add(154); // Urząd Skarbowy w Ciechanowie
		officeCodes.add(155); // Urząd Skarbowy w Działdowie
		officeCodes.add(156); // Urząd Skarbowy w Mławie
		officeCodes.add(157); // Urząd Skarbowy w Płońsku
		officeCodes.add(158); // Urząd Skarbowy w Pułtusku
		officeCodes.add(159); // Pierwszy Urząd Skarbowy w Częstochowie
		officeCodes.add(161); // Urząd Skarbowy w Kłobucku
		officeCodes.add(162); // Urząd Skarbowy w Lublińcu
		officeCodes.add(163); // Urząd Skarbowy w Myszkowie
		officeCodes.add(164); // Urząd Skarbowy w Oleśnie
		officeCodes.add(165); // Urząd Skarbowy w Braniewie
		officeCodes.add(166); // Urząd Skarbowy w Elblągu
		officeCodes.add(167); // Urząd Skarbowy w Kwidzynie
		officeCodes.add(168); // Urząd Skarbowy w Malborku
		officeCodes.add(169); // Pierwszy Urząd Skarbowy w Gdańsku
		officeCodes.add(171); // Drugi Urząd Skarbowy w Gdańsku
		officeCodes.add(172); // Pierwszy Urząd Skarbowy w Gdyni
		officeCodes.add(173); // Urząd Skarbowy w Kartuzach
		officeCodes.add(174); // Urząd Skarbowy w Kościerzynie
		officeCodes.add(175); // Urząd Skarbowy w Pucku
		officeCodes.add(176); // Urząd Skarbowy w Sopocie
		officeCodes.add(177); // Urząd Skarbowy w Starogardzie Gdańskim
		officeCodes.add(178); // Urząd Skarbowy w Tczewie
		officeCodes.add(179); // Urząd Skarbowy w Wejherowie
		officeCodes.add(181); // Urząd Skarbowy w Choszcznie
		officeCodes.add(182); // Urząd Skarbowy w Gorzowie Wielkopolskim
		officeCodes.add(183); // Urząd Skarbowy w Myśliborzu
		officeCodes.add(184); // Urząd Skarbowy w Międzychodzie
		officeCodes.add(185); // Urząd Skarbowy w Międzyrzeczu
		officeCodes.add(186); // Urząd Skarbowy w Słubicach
		officeCodes.add(187); // Urząd Skarbowy w Bolesławcu
		officeCodes.add(188); // Urząd Skarbowy w Jeleniej Górze
		officeCodes.add(189); // Urząd Skarbowy w Kamiennej Górze
		officeCodes.add(191); // Urząd Skarbowy w Lubaniu
		officeCodes.add(192); // Urząd Skarbowy w Lwówku Śląskim
		officeCodes.add(193); // Urząd Skarbowy w Zgorzelcu
		officeCodes.add(194); // Urząd Skarbowy w Jarocinie
		officeCodes.add(195); // Pierwszy Urząd Skarbowy w Kaliszu
		officeCodes.add(196); // Urząd Skarbowy w Kępnie
		officeCodes.add(197); // Urząd Skarbowy w Krotoszynie
		officeCodes.add(198); // Urząd Skarbowy w Ostrowie Wielkopolskim
		officeCodes.add(199); // Urząd Skarbowy w Będzinie
		officeCodes.add(201); // Opolski Urząd Skarbowy w Opolu
		officeCodes.add(202); // Podkarpacki Urząd Skarbowy w Rzeszowie
		officeCodes.add(203); // Podlaski Urząd Skarbowy w Białymstoku
		officeCodes.add(204); // Pomorski Urząd Skarbowy w Gdańsku
		officeCodes.add(205); // Pierwszy Śląski Urząd Skarbowy w Sosnowcu
		officeCodes.add(206); // Drugi Śląski Urząd Skarbowy w Bielsku-Białej
		officeCodes.add(207); // Świętokrzyski Urząd Skarbowy w Kielcach
		officeCodes.add(208); // Warmińsko-Mazurski Urząd Skarbowy w Olsztynie
		officeCodes.add(209); // Pierwszy Wielkopolski Urząd Skarbowy w Poznaniu
		officeCodes.add(211); // Urząd Skarbowy w Bytomiu
		officeCodes.add(212); // Urząd Skarbowy w Chorzowie
		officeCodes.add(213); // Urząd Skarbowy w Chrzanowie
		officeCodes.add(214); // Urząd Skarbowy w Czechowicach-Dziedzicach
		officeCodes.add(215); // Urząd Skarbowy w Dąbrowie Górniczej
		officeCodes.add(216); // Pierwszy Urząd Skarbowy w Gliwicach
		officeCodes.add(217); // Urząd Skarbowy w Jastrzębiu-Zdroju
		officeCodes.add(218); // Urząd Skarbowy w Jaworznie
		officeCodes.add(219); // Pierwszy Urząd Skarbowy w Katowicach
		officeCodes.add(221); // Urząd Skarbowy w Mikołowie
		officeCodes.add(222); // Urząd Skarbowy w Mysłowicach
		officeCodes.add(223); // Urząd Skarbowy w Olkuszu
		officeCodes.add(224); // Urząd Skarbowy w Pszczynie
		officeCodes.add(225); // Urząd Skarbowy w Raciborzu
		officeCodes.add(226); // Urząd Skarbowy w Rudzie Śląskiej
		officeCodes.add(227); // Urząd Skarbowy w Rybniku
		officeCodes.add(228); // Urząd Skarbowy w Siemianowicach Śląskich
		officeCodes.add(229); // Urząd Skarbowy w Sosnowcu
		officeCodes.add(231); // Urząd Skarbowy w Tarnowskich Górach
		officeCodes.add(232); // Urząd Skarbowy w Tychach
		officeCodes.add(233); // Urząd Skarbowy w Wodzisławiu Śląskim
		officeCodes.add(234); // Urząd Skarbowy w Zabrzu
		officeCodes.add(235); // Urząd Skarbowy w Zawierciu
		officeCodes.add(236); // Urząd Skarbowy w Żorach
		officeCodes.add(237); // Urząd Skarbowy w Busku-Zdroju
		officeCodes.add(238); // Urząd Skarbowy w Jędrzejowie
		officeCodes.add(239); // Pierwszy Urząd Skarbowy w Kielcach
		officeCodes.add(241); // Urząd Skarbowy w Końskich
		officeCodes.add(242); // Urząd Skarbowy w Miechowie
		officeCodes.add(243); // Urząd Skarbowy w Ostrowcu Świętokrzyskim
		officeCodes.add(244); // Urząd Skarbowy w Pińczowie
		officeCodes.add(245); // Urząd Skarbowy w Starachowicach
		officeCodes.add(246); // Urząd Skarbowy w Skarżysku-Kamiennej
		officeCodes.add(247); // Urząd Skarbowy w Kole
		officeCodes.add(248); // Urząd Skarbowy w Koninie
		officeCodes.add(249); // Urząd Skarbowy w Słupcy
		officeCodes.add(251); // Urząd Skarbowy w Turku
		officeCodes.add(252); // Urząd Skarbowy w Białogardzie
		officeCodes.add(253); // Urząd Skarbowy w Drawsku Pomorskim
		officeCodes.add(254); // Urząd Skarbowy w Kołobrzegu
		officeCodes.add(255); // Pierwszy Urząd Skarbowy w Koszalinie
		officeCodes.add(256); // Urząd Skarbowy w Szczecinku
		officeCodes.add(257); // Urząd Skarbowy Kraków-Krowodrza
		officeCodes.add(258); // Urząd Skarbowy Kraków-Nowa Huta
		officeCodes.add(259); // Urząd Skarbowy Kraków-Podgórze
		officeCodes.add(261); // Urząd Skarbowy w Kraków-Śródmieście
		officeCodes.add(262); // Urząd Skarbowy w Kraków-Stare Miasto
		officeCodes.add(263); // Urząd Skarbowy w Myślenicach
		officeCodes.add(264); // Urząd Skarbowy w Proszowicach
		officeCodes.add(265); // Urząd Skarbowy w Wieliczce
		officeCodes.add(266); // Urząd Skarbowy w Brzozowie
		officeCodes.add(267); // Urząd Skarbowy w Jaśle
		officeCodes.add(268); // Urząd Skarbowy w Krośnie
		officeCodes.add(269); // Urząd Skarbowy w Lesku
		officeCodes.add(271); // Urząd Skarbowy w Sanoku
		officeCodes.add(272); // Urząd Skarbowy w Ustrzykach Dolnych
		officeCodes.add(273); // Urząd Skarbowy w Głogowie
		officeCodes.add(274); // Urząd Skarbowy w Jaworze
		officeCodes.add(275); // Urząd Skarbowy w Legnicy
		officeCodes.add(276); // Urząd Skarbowy w Lubinie
		officeCodes.add(277); // Urząd Skarbowy w Złotoryi
		officeCodes.add(278); // Urząd Skarbowy w Gostyniu
		officeCodes.add(279); // Urząd Skarbowy w Kościanie
		officeCodes.add(281); // Urząd Skarbowy w Lesznie
		officeCodes.add(282); // Urząd Skarbowy w Rawiczu
		officeCodes.add(283); // Urząd Skarbowy w Kraśniku
		officeCodes.add(284); // Urząd Skarbowy w Lubartowie
		officeCodes.add(285); // Pierwszy Urząd Skarbowy w Lublinie
		officeCodes.add(286); // Drugi Urząd Skarbowy w Lublinie
		officeCodes.add(287); // Urząd Skarbowy w Opolu Lubelskim
		officeCodes.add(288); // Urząd Skarbowy w Puławach
		officeCodes.add(289); // Urząd Skarbowy w Grajewie
		officeCodes.add(291); // Urząd Skarbowy w Kolnie
		officeCodes.add(292); // Urząd Skarbowy w Łomży
		officeCodes.add(293); // Urząd Skarbowy w Wysokiem Mazowieckim
		officeCodes.add(294); // Urząd Skarbowy w Zambrowie
		officeCodes.add(295); // Urząd Skarbowy w Głownie
		officeCodes.add(296); // Pierwszy Urząd Skarbowy Łódź-Bałuty
		officeCodes.add(297); // Pierwszy Urząd Skarbowy Łódź-Górna
		officeCodes.add(298); // Urząd Skarbowy Łódź-Polesie
		officeCodes.add(301); // Drugi Wielkopolski Urząd Skarbowy w Kaliszu
		officeCodes.add(302); // Zachodniopomorski Urząd Skarbowy w Szczecinie
		officeCodes.add(311); // Urząd Skarbowy Łódź-Śródmieście
		officeCodes.add(312); // Urząd Skarbowy Łódź-Widzew
		officeCodes.add(313); // Urząd Skarbowy w Pabianicach
		officeCodes.add(314); // Urząd Skarbowy w Zgierzu
		officeCodes.add(315); // Urząd Skarbowy w Gorlicach
		officeCodes.add(316); // Urząd Skarbowy w Limanowej
		officeCodes.add(317); // Urząd Skarbowy w Nowym Sączu
		officeCodes.add(318); // Urząd Skarbowy w Nowym Targu
		officeCodes.add(319); // Urząd Skarbowy w Zakopanem
		officeCodes.add(321); // Urząd Skarbowy w Bartoszycach
		officeCodes.add(322); // Urząd Skarbowy w Iławie
		officeCodes.add(323); // Urząd Skarbowy w Kętrzynie
		officeCodes.add(324); // Urząd Skarbowy w Olsztynie
		officeCodes.add(325); // Urząd Skarbowy w Ostródzie
		officeCodes.add(326); // Urząd Skarbowy w Szczytnie
		officeCodes.add(327); // Urząd Skarbowy w Brzegu
		officeCodes.add(328); // Urząd Skarbowy w Głubczycach
		officeCodes.add(329); // Urząd Skarbowy w Kędzierzynie-Koźlu
		officeCodes.add(331); // Urząd Skarbowy w Kluczborku
		officeCodes.add(332); // Urząd Skarbowy w Namysłowie
		officeCodes.add(333); // Urząd Skarbowy w Nysie
		officeCodes.add(334); // Pierwszy Urząd Skarbowy w Opolu
		officeCodes.add(335); // Urząd Skarbowy w Prudniku
		officeCodes.add(336); // Urząd Skarbowy w Strzelcach Opolskich
		officeCodes.add(337); // Urząd Skarbowy w Makowie Mazowieckim
		officeCodes.add(338); // Urząd Skarbowy w Ostrołęce
		officeCodes.add(339); // Urząd Skarbowy w Ostrowi Mazowieckiej
		officeCodes.add(341); // Urząd Skarbowy w Przasnyszu
		officeCodes.add(342); // Urząd Skarbowy w Wyszkowie
		officeCodes.add(343); // Urząd Skarbowy w Czarnkowie
		officeCodes.add(344); // Urząd Skarbowy w Pile
		officeCodes.add(345); // Urząd Skarbowy w Wałczu
		officeCodes.add(346); // Urząd Skarbowy w Wągrowcu
		officeCodes.add(347); // Urząd Skarbowy w Złotowie
		officeCodes.add(348); // Urząd Skarbowy w Bełchatowie
		officeCodes.add(349); // Urząd Skarbowy w Opocznie
		officeCodes.add(351); // Urząd Skarbowy w Piotrkowie Trybunalskim
		officeCodes.add(352); // Urząd Skarbowy w Radomsku
		officeCodes.add(353); // Urząd Skarbowy w Tomaszowie Mazowieckim
		officeCodes.add(354); // Urząd Skarbowy w Kutnie
		officeCodes.add(355); // Urząd Skarbowy w Płocku
		officeCodes.add(356); // Urząd Skarbowy w Sierpcu
		officeCodes.add(357); // Urząd Skarbowy w Gnieźnie
		officeCodes.add(358); // Urząd Skarbowy w Nowym Tomyślu
		officeCodes.add(359); // Urząd Skarbowy Poznań-Grunwald
		officeCodes.add(361); // Urząd Skarbowy Poznań-Jeżyce
		officeCodes.add(362); // Urząd Skarbowy Poznań-Nowe Miasto
		officeCodes.add(363); // Pierwszy Urząd Skarbowy Poznań
		officeCodes.add(364); // Urząd Skarbowy Poznań-Śródmieście
		officeCodes.add(365); // Urząd Skarbowy Poznań-Wilda
		officeCodes.add(366); // Urząd Skarbowy w Szamotułach
		officeCodes.add(367); // Urząd Skarbowy w Śremie
		officeCodes.add(368); // Urząd Skarbowy w Środzie Wielkopolskiej
		officeCodes.add(369); // Urząd Skarbowy we Wrześni
		officeCodes.add(371); // Urząd Skarbowy w Jarosławiu
		officeCodes.add(372); // Urząd Skarbowy w Lubaczowie
		officeCodes.add(373); // Urząd Skarbowy w Przemyślu
		officeCodes.add(374); // Urząd Skarbowy w Przeworsku
		officeCodes.add(375); // Urząd Skarbowy w Białobrzegach
		officeCodes.add(376); // Urząd Skarbowy w Grójcu
		officeCodes.add(377); // Urząd Skarbowy w Kozienicach
		officeCodes.add(378); // Pierwszy Urząd Skarbowy w Radomiu
		officeCodes.add(379); // Urząd Skarbowy w Szydłowcu
		officeCodes.add(381); // Urząd Skarbowy w Zwoleniu
		officeCodes.add(382); // Urząd Skarbowy w Kolbuszowej
		officeCodes.add(383); // Urząd Skarbowy w Leżajsku
		officeCodes.add(384); // Urząd Skarbowy w Łańcucie
		officeCodes.add(385); // Urząd Skarbowy w Mielcu
		officeCodes.add(386); // Urząd Skarbowy w Ropczycach
		officeCodes.add(387); // Urząd Skarbowy w Rzeszowie
		officeCodes.add(388); // Urząd Skarbowy w Strzyżowie
		officeCodes.add(389); // Urząd Skarbowy w Garwolinie
		officeCodes.add(391); // Urząd Skarbowy w Łukowie
		officeCodes.add(392); // Urząd Skarbowy w Mińsku Mazowieckim
		officeCodes.add(393); // Urząd Skarbowy w Siedlcach
		officeCodes.add(394); // Urząd Skarbowy w Sokołowie Podlaskim
		officeCodes.add(395); // Urząd Skarbowy w Węgrowie
		officeCodes.add(396); // Urząd Skarbowy w Łasku
		officeCodes.add(397); // Urząd Skarbowy w Poddębicach
		officeCodes.add(398); // Urząd Skarbowy w Sieradzu
		officeCodes.add(399); // Urząd Skarbowy w Wieluniu
		officeCodes.add(411); // Urząd Skarbowy w Zduńskiej Woli
		officeCodes.add(412); // Urząd Skarbowy w Brzezinach
		officeCodes.add(413); // Urząd Skarbowy w Łowiczu
		officeCodes.add(414); // Urząd Skarbowy w Rawie Mazowieckiej
		officeCodes.add(415); // Urząd Skarbowy w Skierniewicach
		officeCodes.add(416); // Urząd Skarbowy w Sochaczewie
		officeCodes.add(417); // Urząd Skarbowy w Żyrardowie
		officeCodes.add(418); // Urząd Skarbowy w Bytowie
		officeCodes.add(419); // Urząd Skarbowy w Człuchowie
		officeCodes.add(421); // Urząd Skarbowy w Lęborku
		officeCodes.add(422); // Urząd Skarbowy w Słupsku
		officeCodes.add(423); // Urząd Skarbowy w Augustowie
		officeCodes.add(424); // Urząd Skarbowy w Ełku
		officeCodes.add(425); // Urząd Skarbowy w Giżycku
		officeCodes.add(426); // Urząd Skarbowy w Olecku
		officeCodes.add(427); // Urząd Skarbowy w Piszu
		officeCodes.add(428); // Urząd Skarbowy w Suwałkach
		officeCodes.add(429); // Urząd Skarbowy w Goleniowie
		officeCodes.add(431); // Urząd Skarbowy w Gryficach
		officeCodes.add(432); // Urząd Skarbowy w Gryfinie
		officeCodes.add(433); // Urząd Skarbowy w Pyrzycach
		officeCodes.add(434); // Urząd Skarbowy w Stargardzie Szczecińskim
		officeCodes.add(435); // Pierwszy Urząd Skarbowy w Szczecinie
		officeCodes.add(436); // Drugi Urząd Skarbowy w Szczecinie
		officeCodes.add(437); // Urząd Skarbowy w Świnoujściu
		officeCodes.add(438); // Urząd Skarbowy w Janowie Lubelskim
		officeCodes.add(439); // Urząd Skarbowy w Opatowie
		officeCodes.add(441); // Urząd Skarbowy w Sandomierzu
		officeCodes.add(442); // Urząd Skarbowy w Stalowej Woli
		officeCodes.add(443); // Urząd Skarbowy w Staszowie
		officeCodes.add(444); // Urząd Skarbowy w Tarnobrzegu
		officeCodes.add(445); // Urząd Skarbowy w Bochni
		officeCodes.add(446); // Urząd Skarbowy w Brzesku
		officeCodes.add(447); // Urząd Skarbowy w Dąbrowie Tarnowskiej
		officeCodes.add(448); // Urząd Skarbowy w Dębicy
		officeCodes.add(449); // Pierwszy Urząd Skarbowy w Tarnowie
		officeCodes.add(451); // Urząd Skarbowy w Brodnicy
		officeCodes.add(452); // Urząd Skarbowy w Chełmnie
		officeCodes.add(453); // Urząd Skarbowy w Grudziądzu
		officeCodes.add(454); // Urząd Skarbowy w Nowym Mieście Lubawskim
		officeCodes.add(455); // Drugi Urząd Skarbowy w Toruniu
		officeCodes.add(456); // Urząd Skarbowy w Wąbrzeźnie
		officeCodes.add(457); // Urząd Skarbowy w Bystrzycy Kłodzkiej
		officeCodes.add(458); // Urząd Skarbowy w Dzierżoniowie
		officeCodes.add(459); // Urząd Skarbowy w Kłodzku
		officeCodes.add(461); // Urząd Skarbowy w Nowej Rudzie
		officeCodes.add(462); // Urząd Skarbowy w Świdnicy
		officeCodes.add(463); // Urząd Skarbowy w Wałbrzychu
		officeCodes.add(464); // Urząd Skarbowy w Ząbkowicach Śląskich
		officeCodes.add(465); // Urząd Skarbowy w Aleksandrowie Kujawskim
		officeCodes.add(466); // Urząd Skarbowy w Lipnie
		officeCodes.add(467); // Urząd Skarbowy w Radziejowie
		officeCodes.add(468); // Urząd Skarbowy w Rypinie
		officeCodes.add(469); // Urząd Skarbowy we Włocławku
		officeCodes.add(471); // Urząd Skarbowy Wrocław-Fabryczna
		officeCodes.add(472); // Urząd Skarbowy Wrocław-Krzyki
		officeCodes.add(473); // Urząd Skarbowy Wrocław-Psie Pole
		officeCodes.add(474); // Urząd Skarbowy Wrocław-Stare Miasto
		officeCodes.add(475); // Pierwszy Urząd Skarbowy we Wrocławiu
		officeCodes.add(476); // Drugi Urząd Skarbowy Wrocław-Śródmieście
		officeCodes.add(477); // Urząd Skarbowy w Miliczu
		officeCodes.add(478); // Urząd Skarbowy w Oleśnicy
		officeCodes.add(479); // Urząd Skarbowy w Oławie
		officeCodes.add(481); // Urząd Skarbowy w Strzelnie
		officeCodes.add(482); // Urząd Skarbowy w Środzie Śląskiej
		officeCodes.add(483); // Urząd Skarbowy w Trzebnicy
		officeCodes.add(484); // Urząd Skarbowy w Biłgoraju
		officeCodes.add(485); // Urząd Skarbowy w Hrubieszowie
		officeCodes.add(486); // Urząd Skarbowy w Tomaszowie Lubelskim
		officeCodes.add(487); // Urząd Skarbowy w Zamościu
		officeCodes.add(488); // Urząd Skarbowy w Krośnie Odrzańskim
		officeCodes.add(489); // Urząd Skarbowy w Nowej Soli
		officeCodes.add(491); // Urząd Skarbowy w Świebodzinie
		officeCodes.add(492); // Urząd Skarbowy w Wolsztynie
		officeCodes.add(493); // Pierwszy Urząd Skarbowy w Zielonej Górze
		officeCodes.add(494); // Urząd Skarbowy w Żaganiu
		officeCodes.add(495); // Urząd Skarbowy w Żarach
		officeCodes.add(496); // Urząd Skarbowy w Łosicach
		officeCodes.add(497); // Urząd Skarbowy w Łosicach
		officeCodes.add(498); // Urząd Skarbowy w Piekarach Śląskich
		officeCodes.add(499); // Drugi Urząd Skarbowy w Koszalinie
		officeCodes.add(501); // Urząd Skarbowy W Górze
		officeCodes.add(502); // Urząd Skarbowy W Polkowicach
		officeCodes.add(503); // Urząd Skarbowy W Golubiu-Dobrzyniu
		officeCodes.add(504); // Urząd Skarbowy W Sepólnie Krajeńskim
		officeCodes.add(505); // Urząd Skarbowy W Łęcznej
		officeCodes.add(506); // Urząd Skarbowy W Rykach
		officeCodes.add(507); // Urząd Skarbowy W Łęczycy
		officeCodes.add(508); // Urząd Skarbowy W Pajęcznie
		officeCodes.add(509); // Urząd Skarbowy W Lipsku
		officeCodes.add(511); // Urząd Skarbowy w Żurominie
		officeCodes.add(512); // Urząd Skarbowy w Żurominie
		officeCodes.add(513); // Urząd Skarbowy w Lesznie
		officeCodes.add(514); // Urząd Skarbowy w Ostrzeszowie
		officeCodes.add(516); // Urząd Skarbowy w Ostrzeszowie
		officeCodes.add(519); // Urząd Skarbowy w Legionowie
		officeCodes.add(521); // Urząd Skarbowy Warszawa-Mokotów
		officeCodes.add(522); // Urząd Skarbowy Warszawa-Bemowo
		officeCodes.add(523); // Urząd Skarbowy Warszawa-Praga
		officeCodes.add(524); // Urząd Skarbowy Warszawa-Targówek
		officeCodes.add(525); // Pierwszy Urząd Skarbowy Warszawa-Śródmieście
		officeCodes.add(526); // Drugi Urząd Skarbowy Warszawa-Śródmieście
		officeCodes.add(527); // Urząd Skarbowy Warszawa-Wola
		officeCodes.add(528); // Urząd Skarbowy Warszawa-Bielany
		officeCodes.add(529); // Urząd Skarbowy w Grodzisku Mazowieckim
		officeCodes.add(531); // Urząd Skarbowy w Nowym Dworze Mazowieckim
		officeCodes.add(532); // Urząd Skarbowy w Otwocku
		officeCodes.add(533); // Urząd Skarbowy w Piasecznie
		officeCodes.add(534); // Urząd Skarbowy w Pruszkowie
		officeCodes.add(535); // Urząd Skarbowy w Wołominie
		officeCodes.add(536); // Urząd Skarbowy w Legionowie
		officeCodes.add(537); // Urząd Skarbowy w Białej Podlaskiej
		officeCodes.add(538); // Urząd Skarbowy w Radzyniu Podlaskim
		officeCodes.add(539); // Urząd Skarbowy w Parczewie
		officeCodes.add(541); // Filia US w Białej Podlaskiej/Łosice
		officeCodes.add(542); // Pierwszy Urząd Skarbowy w Białymstoku
		officeCodes.add(543); // Urząd Skarbowy w Bielsku Podlaskim
		officeCodes.add(544); // Urząd Skarbowy w Siemiatyczach
		officeCodes.add(545); // Urząd Skarbowy w Sokółce
		officeCodes.add(546); // Urząd Skarbowy w Mońkach
		officeCodes.add(547); // Pierwszy Urząd Skarbowy w Bielsku-Białej
		officeCodes.add(548); // Urząd Skarbowy w Cieszynie
		officeCodes.add(549); // Urząd Skarbowy w Oświęcimiu
		officeCodes.add(551); // Urząd Skarbowy w Wadowicach
		officeCodes.add(552); // Urząd Skarbowy w Suchej Beskidzkiej
		officeCodes.add(553); // Urząd Skarbowy w Żywcu
		officeCodes.add(554); // Pierwszy Urząd Skarbowy w Bydgoszczy
		officeCodes.add(555); // Urząd Skarbowy w Chojnicach
		officeCodes.add(556); // Urząd Skarbowy w Inowrocławiu
		officeCodes.add(557); // Urząd Skarbowy w Mogilnie
		officeCodes.add(558); // Urząd Skarbowy w Nakle nad Notecią
		officeCodes.add(559); // Urząd Skarbowy w Świeciu
		officeCodes.add(561); // Urząd Skarbowy w Tucholi
		officeCodes.add(562); // Urząd Skarbowy w Żninie
		officeCodes.add(563); // Urząd Skarbowy w Chełmie
		officeCodes.add(564); // Urząd Skarbowy w Krasnymstawie
		officeCodes.add(565); // Urząd Skarbowy we Włodawie
		officeCodes.add(566); // Urząd Skarbowy w Ciechanowie
		officeCodes.add(567); // Urząd Skarbowy w Płońsku
		officeCodes.add(568); // Urząd Skarbowy w Pułtusku
		officeCodes.add(569); // Urząd Skarbowy w Mławie
		officeCodes.add(571); // Urząd Skarbowy w Działdowie
		officeCodes.add(572); // Filia US w Mławie/Żuromin
		officeCodes.add(573); // Pierwszy Urząd Skarbowy w Częstochowie
		officeCodes.add(574); // Urząd Skarbowy w Kłobucku
		officeCodes.add(575); // Urząd Skarbowy w Lublińcu
		officeCodes.add(576); // Urząd Skarbowy w Oleśnie
		officeCodes.add(577); // Urząd Skarbowy w Myszkowie
		officeCodes.add(578); // Urząd Skarbowy w Elblągu
		officeCodes.add(579); // Urząd Skarbowy w Malborku
		officeCodes.add(581); // Urząd Skarbowy w Kwidzynie
		officeCodes.add(582); // Urząd Skarbowy w Braniewie
		officeCodes.add(583); // Pierwszy Urząd Skarbowy w Gdańsku
		officeCodes.add(584); // Drugi Urząd Skarbowy w Gdańsku
		officeCodes.add(585); // Urząd Skarbowy w Sopocie
		officeCodes.add(586); // Pierwszy Urząd Skarbowy w Gdyni
		officeCodes.add(587); // Urząd Skarbowy w Pucku
		officeCodes.add(588); // Urząd Skarbowy w Wejherowie
		officeCodes.add(589); // Urząd Skarbowy w Kartuzach
		officeCodes.add(591); // Urząd Skarbowy w Kościerzynie
		officeCodes.add(592); // Urząd Skarbowy w Starogardzie Gdańskim
		officeCodes.add(593); // Urząd Skarbowy w Tczewie
		officeCodes.add(594); // Urząd Skarbowy w Choszcznie
		officeCodes.add(595); // Urząd Skarbowy w Międzychodzie
		officeCodes.add(596); // Urząd Skarbowy w Międzyrzeczu
		officeCodes.add(597); // Urząd Skarbowy w Myśliborzu
		officeCodes.add(598); // Urząd Skarbowy w Słubicach
		officeCodes.add(599); // Urząd Skarbowy w Gorzowie Wielkopolskim
		officeCodes.add(601); // Urząd Skarbowy w Przysusze
		officeCodes.add(602); // Urząd Skarbowy w Nisku
		officeCodes.add(603); // Urząd Skarbowy w Hajnówce
		officeCodes.add(604); // Urząd Skarbowy w Pruszczu Gdańskim
		officeCodes.add(605); // Urząd Skarbowy w Kazimierzy Wielkiej
		officeCodes.add(606); // Urząd Skarbowy w Obornikach
		officeCodes.add(607); // Urząd Skarbowy w Chodzieży
		officeCodes.add(608); // Urząd Skarbowy w Pleszewie
		officeCodes.add(609); // Urząd Skarbowy we Włoszczowie
		officeCodes.add(611); // Urząd Skarbowy w Jeleniej-Górze
		officeCodes.add(612); // Urząd Skarbowy w Bolesławcu
		officeCodes.add(613); // Urząd Skarbowy w Lubaniu
		officeCodes.add(614); // Urząd Skarbowy w Kamiennej-Górze
		officeCodes.add(615); // Urząd Skarbowy w Zgorzelcu
		officeCodes.add(616); // Urząd Skarbowy w Lwówku ŚLąskim
		officeCodes.add(617); // Urząd Skarbowy w Jarocinie
		officeCodes.add(618); // Pierwszy Urząd Skarbowy w Kaliszu
		officeCodes.add(619); // Urząd Skarbowy w Kępnie
		officeCodes.add(621); // Urząd Skarbowy w Krotoszynie
		officeCodes.add(622); // Urząd Skarbowy w Ostrowie Wielkopolskim
		officeCodes.add(623); // Urząd Skarbowy w Piekarach Śląskich
		officeCodes.add(624); // Drugi Urząd Skarbowy w Koszalinie
		officeCodes.add(625); // Urząd Skarbowy w Będzinie
		officeCodes.add(626); // Urząd Skarbowy w Bytomiu
		officeCodes.add(627); // Urząd Skarbowy w Chorzowie
		officeCodes.add(628); // Urząd Skarbowy w Chrzanowie
		officeCodes.add(629); // Urząd Skarbowy w Dąbrowie Górniczej
		officeCodes.add(631); // Pierwszy Urząd Skarbowy w Gliwicach
		officeCodes.add(632); // Urząd Skarbowy w Jaworznie
		officeCodes.add(633); // Urząd Skarbowy w Jastrzębiu-Zdroju
		officeCodes.add(634); // Pierwszy Urząd Skarbowy w Katowicach
		officeCodes.add(635); // Urząd Skarbowy w Mikołowie
		officeCodes.add(636); // Urząd Skarbowy w Mysłowicach
		officeCodes.add(637); // Urząd Skarbowy w Olkuszu
		officeCodes.add(638); // Urząd Skarbowy w Pszczynie
		officeCodes.add(639); // Urząd Skarbowy w Raciborzu
		officeCodes.add(641); // Urząd Skarbowy w Rudzie Śląskiej
		officeCodes.add(642); // Urząd Skarbowy w Rybniku
		officeCodes.add(643); // Urząd Skarbowy w Siemianowicach Śląskich
		officeCodes.add(644); // Urząd Skarbowy w Sosnowcu
		officeCodes.add(645); // Urząd Skarbowy w Tarnowskich Górach
		officeCodes.add(646); // Urząd Skarbowy w Tychach
		officeCodes.add(647); // Urząd Skarbowy w Wodzisławiu Śląskim
		officeCodes.add(648); // Urząd Skarbowy w Zabrzu
		officeCodes.add(649); // Urząd Skarbowy w Zawierciu
		officeCodes.add(651); // Urząd Skarbowy w Żorach
		officeCodes.add(652); // Urząd Skarbowy w Czechowicach Dziedzicach
		officeCodes.add(653); // Urząd Skarbowy Tarnowskie Góry filia Piekary
								// Śląskie
		officeCodes.add(654); // Filia US w Będzinie/Czeladź
		officeCodes.add(655); // Urząd Skarbowy w Busku-Zdroju
		officeCodes.add(656); // Urząd Skarbowy w Jędrzejowie
		officeCodes.add(657); // Pierwszy Urząd Skarbowy w Kielcach
		officeCodes.add(658); // Urząd Skarbowy w Końskich
		officeCodes.add(659); // Urząd Skarbowy w Miechowie
		officeCodes.add(661); // Urząd Skarbowy w Ostrowcu Świętokrzyskim
		officeCodes.add(662); // Urząd Skarbowy w Pińczowie
		officeCodes.add(663); // Urząd Skarbowy w Skarżysku Kamiennej
		officeCodes.add(664); // Urząd Skarbowy w Starachowicach
		officeCodes.add(665); // Urząd Skarbowy w Koninie
		officeCodes.add(666); // Urząd Skarbowy w Kole
		officeCodes.add(667); // Urząd Skarbowy w Słupcy
		officeCodes.add(668); // Urząd Skarbowy w Turku
		officeCodes.add(669); // Pierwszy Urząd Skarbowy w Koszalinie
		officeCodes.add(671); // Urząd Skarbowy w Kołobrzegu
		officeCodes.add(672); // Urząd Skarbowy w Białogardzie
		officeCodes.add(673); // Urząd Skarbowy w Szczecinku
		officeCodes.add(674); // Urząd Skarbowy w Drawsku Pomorskim
		officeCodes.add(675); // Urząd Skarbowy Kraków-Śródmieście
		officeCodes.add(676); // Urząd Skarbowy Kraków-Stare Miasto
		officeCodes.add(677); // Urząd Skarbowy Kraków-Krowodrza
		officeCodes.add(678); // Urząd Skarbowy Kraków-Nowa Huta
		officeCodes.add(679); // Urząd Skarbowy Kraków-Podgórze
		officeCodes.add(681); // Urząd Skarbowy w Myślenicach
		officeCodes.add(682); // Urząd Skarbowy w Proszowicach
		officeCodes.add(683); // Urząd Skarbowy w Wieliczce
		officeCodes.add(684); // Urząd Skarbowy w Krośnie
		officeCodes.add(685); // Urząd Skarbowy w Jaśle
		officeCodes.add(686); // Urząd Skarbowy w Brzozowie
		officeCodes.add(687); // Urząd Skarbowy w Sanoku
		officeCodes.add(688); // Urząd Skarbowy w Lesku
		officeCodes.add(689); // Urząd Skarbowy w Ustrzykach Dolnych
		officeCodes.add(691); // Urząd Skarbowy w Legnicy
		officeCodes.add(692); // Urząd Skarbowy w Lubinie
		officeCodes.add(693); // Urząd Skarbowy w Głogowie
		officeCodes.add(694); // Urząd Skarbowy w Złotoryi
		officeCodes.add(695); // Urząd Skarbowy w Jaworze
		officeCodes.add(696); // Urząd Skarbowy w Gostyniu
		officeCodes.add(697); // Urząd Skarbowy w Lesznie
		officeCodes.add(698); // Urząd Skarbowy w Kościanie
		officeCodes.add(699); // Urząd Skarbowy w Rawiczu
		officeCodes.add(701); // Trzeci Urząd Skarbowy Warszawa-Śródmieście
		officeCodes.add(711); // Urząd Skarbowy w Lesznie
		officeCodes.add(712); // Pierwszy Urząd Skarbowy w Lublinie
		officeCodes.add(713); // Drugi Urząd Skarbowy w Lublinie
		officeCodes.add(714); // Urząd Skarbowy w Lubartowie
		officeCodes.add(715); // Urząd Skarbowy w Kraśniku
		officeCodes.add(716); // Urząd Skarbowy w Puławach
		officeCodes.add(717); // Urząd Skarbowy w Opolu Lubelskim
		officeCodes.add(718); // Urząd Skarbowy w Łomży
		officeCodes.add(719); // Urząd Skarbowy w Grajewie
		officeCodes.add(721); // Urząd Skarbowy w Kolnie
		officeCodes.add(722); // Urząd Skarbowy w Wysokiem Mazowieckiem
		officeCodes.add(723); // Urząd Skarbowy w Zambrowie
		officeCodes.add(724); // Pierwszy Urząd Skarbowy Łódź-Śródmieście
		officeCodes.add(725); // Urząd Skarbowy Łódź-Śródmieście
		officeCodes.add(726); // Pierwszy Urząd Skarbowy Łódź-Bałuty
		officeCodes.add(727); // Urząd Skarbowy Łódź-Polesie
		officeCodes.add(728); // Urząd Skarbowy Łódź-Widzew
		officeCodes.add(729); // Pierwszy Urząd Skarbowy Łódź-Górna
		officeCodes.add(731); // Urząd Skarbowy w Pabianicach
		officeCodes.add(732); // Urząd Skarbowy w Zgierzu
		officeCodes.add(733); // Urząd Skarbowy w Głownie
		officeCodes.add(734); // Urząd Skarbowy w Nowym Sączu
		officeCodes.add(735); // Urząd Skarbowy w Nowym Targu
		officeCodes.add(736); // Urząd Skarbowy w Zakopanem
		officeCodes.add(737); // Urząd Skarbowy w Limanowej
		officeCodes.add(738); // Urząd Skarbowy w Gorlicach
		officeCodes.add(739); // Urząd Skarbowy w Olsztynie
		officeCodes.add(741); // Urząd Skarbowy w Ostródzie
		officeCodes.add(742); // Urząd Skarbowy w Kętrzynie
		officeCodes.add(743); // Urząd Skarbowy w Bartoszycach
		officeCodes.add(744); // Urząd Skarbowy w Iławie
		officeCodes.add(745); // Urząd Skarbowy w Szczytnie
		officeCodes.add(746); // Filia US w Szczytnie/Nidzica
		officeCodes.add(747); // Urząd Skarbowy w Brzegu
		officeCodes.add(748); // Urząd Skarbowy w Głubczycach
		officeCodes.add(749); // Urząd Skarbowy w Kędzierzynie-Koźlu
		officeCodes.add(751); // Urząd Skarbowy w Kluczborku
		officeCodes.add(752); // Urząd Skarbowy w Namysłowie
		officeCodes.add(753); // Urząd Skarbowy w Nysie
		officeCodes.add(754); // Pierwszy Urząd Skarbowy w Opolu
		officeCodes.add(755); // Urząd Skarbowy w Prudniku
		officeCodes.add(756); // Urząd Skarbowy w Strzelcach Opolskich
		officeCodes.add(757); // Urząd Skarbowy w Makowie Mazowieckim
		officeCodes.add(758); // Urząd Skarbowy w Ostrołęce
		officeCodes.add(759); // Urząd Skarbowy w Ostrowi Mazowieckiej
		officeCodes.add(761); // Urząd Skarbowy w Przasnyszu
		officeCodes.add(762); // Urząd Skarbowy w Wyszkowie
		officeCodes.add(763); // Urząd Skarbowy w Czarnkowie
		officeCodes.add(764); // Urząd Skarbowy w Pile
		officeCodes.add(765); // Urząd Skarbowy w Wałczu
		officeCodes.add(766); // Urząd Skarbowy w Wągrowcu
		officeCodes.add(767); // Urząd Skarbowy w Złotowie
		officeCodes.add(768); // Urząd Skarbowy w Opocznie
		officeCodes.add(769); // Urząd Skarbowy w Bełchatowie
		officeCodes.add(771); // Urząd Skarbowy w Piotrkowie Trybunalskim
		officeCodes.add(772); // Urząd Skarbowy w Radomsku
		officeCodes.add(773); // Urząd Skarbowy w Tomaszowie Mazowieckim
		officeCodes.add(774); // Urząd Skarbowy w Płocku
		officeCodes.add(775); // Urząd Skarbowy w Kutnie
		officeCodes.add(776); // Urząd Skarbowy w Sierpcu
		officeCodes.add(777); // Pierwszy Urząd Skarbowy Poznań
		officeCodes.add(778); // Urząd Skarbowy Poznań-Śródmieście
		officeCodes.add(779); // Urząd Skarbowy Poznań-Grunwald
		officeCodes.add(781); // Urząd Skarbowy Poznań-Jeżyce
		officeCodes.add(782); // Urząd Skarbowy Poznań-Nowe Miasto
		officeCodes.add(783); // Urząd Skarbowy Poznań-Wilda
		officeCodes.add(784); // Urząd Skarbowy w Gnieźnie
		officeCodes.add(785); // Urząd Skarbowy w Śremie
		officeCodes.add(786); // Urząd Skarbowy w Środzie Wielkopolskiej
		officeCodes.add(787); // Urząd Skarbowy w Szamotułach
		officeCodes.add(788); // Urząd Skarbowy w Nowym Tomyślu
		officeCodes.add(789); // Urząd Skarbowy we Wrześni
		officeCodes.add(791); // Filia US w Nowym Tomyślu/Grodzisk Wlkp.
		officeCodes.add(792); // Urząd Skarbowy w Jarosławiu
		officeCodes.add(793); // Urząd Skarbowy w Lubaczowie
		officeCodes.add(794); // Urząd Skarbowy w Przeworsku
		officeCodes.add(795); // Urząd Skarbowy w Przemyślu
		officeCodes.add(796); // Pierwszy Urząd Skarbowy w Radomiu
		officeCodes.add(797); // Urząd Skarbowy w Grójcu
		officeCodes.add(798); // Urząd Skarbowy w Białobrzegach
		officeCodes.add(799); // Urząd Skarbowy w Szydłowcu
		officeCodes.add(811); // Urząd Skarbowy w Zwoleniu
		officeCodes.add(812); // Urząd Skarbowy w Kozienicach
		officeCodes.add(813); // Urząd Skarbowy w Rzeszowie
		officeCodes.add(814); // Urząd Skarbowy w Kolbuszowej
		officeCodes.add(815); // Urząd Skarbowy w Łańcucie
		officeCodes.add(816); // Urząd Skarbowy w Leżajsku
		officeCodes.add(817); // Urząd Skarbowy w Mielcu
		officeCodes.add(818); // Urząd Skarbowy w Ropczycach
		officeCodes.add(819); // Urząd Skarbowy w Strzyżowie
		officeCodes.add(821); // Urząd Skarbowy w Siedlcach
		officeCodes.add(822); // Urząd Skarbowy w Mińsku Mazowieckim
		officeCodes.add(823); // Urząd Skarbowy w Sokołowie Podlaskim
		officeCodes.add(824); // Urząd Skarbowy w Węgrowie
		officeCodes.add(825); // Urząd Skarbowy w Łukowie
		officeCodes.add(826); // Urząd Skarbowy w Garwolinie
		officeCodes.add(827); // Urząd Skarbowy w Sieradzu
		officeCodes.add(828); // Urząd Skarbowy w Poddębicach
		officeCodes.add(829); // Urząd Skarbowy w Zduńskiej Woli
		officeCodes.add(831); // Urząd Skarbowy w Łasku
		officeCodes.add(832); // Urząd Skarbowy w Wieluniu
		officeCodes.add(833); // Urząd Skarbowy w Brzezinach
		officeCodes.add(834); // Urząd Skarbowy w Łowiczu
		officeCodes.add(835); // Urząd Skarbowy w Rawie Mazowieckiej
		officeCodes.add(836); // Urząd Skarbowy w Skierniewicach
		officeCodes.add(837); // Urząd Skarbowy w Sochaczewie
		officeCodes.add(838); // Urząd Skarbowy w Żyrardowie
		officeCodes.add(839); // Urząd Skarbowy w Słupsku
		officeCodes.add(841); // Urząd Skarbowy w Lęborku
		officeCodes.add(842); // Urząd Skarbowy w Bytowie
		officeCodes.add(843); // Urząd Skarbowy w Człuchowie
		officeCodes.add(844); // Urząd Skarbowy w Suwałkach
		officeCodes.add(845); // Urząd Skarbowy w Giżycku
		officeCodes.add(846); // Urząd Skarbowy w Augustowie
		officeCodes.add(847); // Urząd Skarbowy w Olecku
		officeCodes.add(848); // Urząd Skarbowy w Ełku
		officeCodes.add(849); // Urząd Skarbowy w Piszu
		officeCodes.add(851); // Pierwszy Urząd Skarbowy w Szczecinie
		officeCodes.add(852); // Drugi Urząd Skarbowy w Szczecinie
		officeCodes.add(853); // Urząd Skarbowy w Pyrzycach
		officeCodes.add(854); // Urząd Skarbowy w Starogardzie Szczecińskim
		officeCodes.add(855); // Urząd Skarbowy w Świnoujściu
		officeCodes.add(856); // Urząd Skarbowy w Goleniowie
		officeCodes.add(857); // Urząd Skarbowy w Gryficach
		officeCodes.add(858); // Urząd Skarbowy w Gryfinie
		officeCodes.add(859); // Filia US w Goleniowie/Nowogard
		officeCodes.add(861); // Filia US w Gryficach/Kamień Pom.
		officeCodes.add(862); // Urząd Skarbowy w Janowie Lubelskim
		officeCodes.add(863); // Urząd Skarbowy w Opatowie
		officeCodes.add(864); // Urząd Skarbowy w Sandomierzu
		officeCodes.add(865); // Urząd Skarbowy w Stalowej Woli
		officeCodes.add(866); // Urząd Skarbowy w Staszowie
		officeCodes.add(867); // Urząd Skarbowy w Tarnobrzegu
		officeCodes.add(868); // Urząd Skarbowy w Bochni
		officeCodes.add(869); // Urząd Skarbowy w Brzesku
		officeCodes.add(871); // Urząd Skarbowy w Dąbrowie Tarnowskiej
		officeCodes.add(872); // Urząd Skarbowy w Dębicy
		officeCodes.add(873); // Pierwszy Urząd Skarbowy w Tarnowie
		officeCodes.add(874); // Urząd Skarbowy w Brodnicy
		officeCodes.add(875); // Urząd Skarbowy w Chełmnie
		officeCodes.add(876); // Urząd Skarbowy w Grudziądzu
		officeCodes.add(877); // Urząd Skarbowy w Nowym Mieście Lubawskim
		officeCodes.add(878); // Urząd Skarbowy w Wąbrzeźnie
		officeCodes.add(879); // Drugi Urząd Skarbowy w Toruniu
		officeCodes.add(881); // Urząd Skarbowy w Bystrzycy Kłodzkiej
		officeCodes.add(882); // Urząd Skarbowy w Dzierżoniowie
		officeCodes.add(883); // Urząd Skarbowy w Kłodzku
		officeCodes.add(884); // Urząd Skarbowy w Świdnicy
		officeCodes.add(885); // Urząd Skarbowy w Nowej Rudzie
		officeCodes.add(886); // Urząd Skarbowy w Wałbrzychu
		officeCodes.add(887); // Urząd Skarbowy w Ząbkowicach Śląskich
		officeCodes.add(888); // Urząd Skarbowy w Włocławku
		officeCodes.add(889); // Urząd Skarbowy w Radziejowie
		officeCodes.add(891); // Urząd Skarbowy w Aleksandrowie Kujawskim
		officeCodes.add(892); // Urząd Skarbowy w Rypinie
		officeCodes.add(893); // Urząd Skarbowy w Lipnie
		officeCodes.add(894); // Urząd Skarbowy Wrocław-Fabryczna
		officeCodes.add(895); // Urząd Skarbowy Wrocław-Psie Pole
		officeCodes.add(896); // Pierwszy Urząd Skarbowy we Wrocławiu
		officeCodes.add(897); // Urząd Skarbowy Wrocław-Stare Miasto
		officeCodes.add(898); // Drugi Urząd Skarbowy Wrocław-Śródmieście
		officeCodes.add(899); // Urząd Skarbowy Wrocław-Krzyki
		officeCodes.add(911); // Urząd Skarbowy w Oleśnicy
		officeCodes.add(912); // Urząd Skarbowy w Oławie
		officeCodes.add(913); // Urząd Skarbowy w Środzie Wielkopolskiej
		officeCodes.add(914); // Urząd Skarbowy w Strzelnie
		officeCodes.add(915); // Urząd Skarbowy w Trzebnicy
		officeCodes.add(916); // Urząd Skarbowy w Miliczu
		officeCodes.add(917); // Filia US w Trzebnicy/Wołów
		officeCodes.add(918); // Urząd Skarbowy w Biłgoraju
		officeCodes.add(919); // Urząd Skarbowy w Hrubieszowie
		officeCodes.add(921); // Urząd Skarbowy w Tomaszowie Lubelskim
		officeCodes.add(922); // Urząd Skarbowy w Zamościu
		officeCodes.add(923); // Urząd Skarbowy w Wolsztynie
		officeCodes.add(924); // Urząd Skarbowy w Żaganiu
		officeCodes.add(925); // Urząd Skarbowy w Nowej Soli
		officeCodes.add(926); // Urząd Skarbowy w Krośnie Odrzańskim
		officeCodes.add(927); // Urząd Skarbowy w Świebodzinie
		officeCodes.add(928); // Urząd Skarbowy w Żarach
		officeCodes.add(929); // Pierwszy Urząd Skarbowy w Zielonej Górze
		officeCodes.add(931); // Urząd Skarbowy Warszawa-Ursynów
		officeCodes.add(932); // Urząd Skarbowy Warszawa-Wawer
		officeCodes.add(933); // Drugi Urząd Skarbowy w Bydgoszczy
		officeCodes.add(934); // Drugi Urząd Skarbowy w Katowicach
		officeCodes.add(935); // Trzeci Urząd Skarbowy w Szczecinie
		officeCodes.add(936); // Pierwszy Urząd Skarbowy w Toruniu
		officeCodes.add(937); // Drugi Urząd Skarbowy w Bielsku-Białej
		officeCodes.add(938); // Drugi Urząd Skarbowy w Bielsku-Białej
		officeCodes.add(939); // Drugi Urząd Skarbowy w Częstochowie
		officeCodes.add(941); // Trzeci Urząd Skarbowy w Gdańsku
		officeCodes.add(942); // Drugi Urząd Skarbowy w Gdyni
		officeCodes.add(943); // Drugi Urząd Skarbowy w Kielcach
		officeCodes.add(944); // Urząd Skarbowy Kraków-Dębniki
		officeCodes.add(945); // Urząd Skarbowy Kraków-Prądnik
		officeCodes.add(946); // Trzeci Urząd Skarbowy w Lublinie
		officeCodes.add(947); // Drugi Urząd Skarbowy Łódź-Bałuty
		officeCodes.add(948); // Drugi Urząd Skarbowy w Radomiu
		officeCodes.add(949); // Drugi Urząd Skarbowy w Częstochowie
		officeCodes.add(951); // Urząd Skarbowy Warszawa-Ursynów
		officeCodes.add(952); // Urząd Skarbowy Warszawa-Wawer
		officeCodes.add(953); // Drugi Urząd Skarbowy w Bydgoszczy
		officeCodes.add(954); // Drugi Urząd Skarbowy w Katowicach
		officeCodes.add(955); // Trzeci Urząd Skarbowy w Szczecinie
		officeCodes.add(956); // Pierwszy Urząd Skarbowy w Toruniu
		officeCodes.add(957); // Trzeci Urząd Skarbowy w Gdańsku
		officeCodes.add(958); // Drugi Urząd Skarbowy w Gdyni
		officeCodes.add(959); // Drugi Urząd Skarbowy w Kielcach
		officeCodes.add(961); // Urząd Skarbowy Kraków-Dębniki
		officeCodes.add(962); // Urząd Skarbowy Kraków-Prądnik
		officeCodes.add(963); // Trzeci Urząd Skarbowy w Lublinie
		officeCodes.add(964); // Drugi Urząd Skarbowy Łódź-Bałuty
		officeCodes.add(965); // Drugi Urząd Skarbowy w Radomiu
		officeCodes.add(966); // Drugi Urząd Skarbowy w Białymstoku
		officeCodes.add(967); // Trzeci Urząd Skarbowy w Bydgoszczy
		officeCodes.add(968); // Drugi Urząd Skarbowy w Kaliszu
		officeCodes.add(969); // Drugi Urząd Skarbowy w Gliwicach
		officeCodes.add(971); // Urząd Skarbowy w Gostyninie
		officeCodes.add(972); // Urząd Skarbowy Poznań-Winogrady
		officeCodes.add(973); // Drugi Urząd Skarbowy w Zielonej-Górze
		officeCodes.add(974); // Drugi Urząd Skarbowy w Białymstoku
		officeCodes.add(975); // Trzeci Urząd Skarbowy w Bydgoszczy
		officeCodes.add(976); // Drugi Urząd Skarbowy w Bydgoszczy
		officeCodes.add(977); // Drugi Urząd Skarbowy w Gliwicach
		officeCodes.add(978); // Urząd Skarbowy w Gostyninie
		officeCodes.add(979); // Urząd Skarbowy Poznań-Winogrady
		officeCodes.add(981); // Drugi Urząd Skarbowy w Zielonej Górze
		officeCodes.add(982); // Drugi Urząd Skarbowy Łódź-Górna
		officeCodes.add(983); // Drugi Urząd Skarbowy Łódź-Górna
		officeCodes.add(984); // Urząd Skarbowy w Nidzicy
		officeCodes.add(985); // Urząd Skarbowy w Nidzicy
		officeCodes.add(986); // Urząd Skarbowy w Kamieniu Pomorskim
		officeCodes.add(987); // Urząd Skarbowy w Kamieniu Pomorskim
		officeCodes.add(988); // Urząd Skarbowy w Wołowie
		officeCodes.add(989); // Urząd Skarbowy w Wołowie
		officeCodes.add(991); // Drugi Urząd Skarbowy w Opolu
		officeCodes.add(992); // Drugi Urząd Skarbowy w Opolu
		officeCodes.add(993); // Drugi Urząd Skarbowy w Tarnowie
		officeCodes.add(994); // Drugi Urząd Skarbowy w Tarnowie
		officeCodes.add(995); // Urząd Skarbowy w Grodzisku Wielkopolskim
		officeCodes.add(996); // Urząd Skarbowy w Grodzisku Wielkopolskim
		officeCodes.add(997); // Urząd Skarbowy Wieluń lokalizacja w Wieruszowie
		officeCodes.add(998); // Urząd Skarbowy Wieluń lokalizacja w Wieruszowie
	}

}
