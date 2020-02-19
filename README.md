# DataGenerator Library
Simple library that allows to crate random data used for testing purposes, like:
* company information (name, registration number ans vat identification number),
* person (name, surname, gender, birth date and ssn number),
* address (area code, state, city, street name, flat and house number),
* phone numbers (country code, stationary and mobile phone number).

Additionaly, it's possible to create random:
* lorem ipsum sentences (default *'Lorem ipsum dolor sit amet.'* and using provided parameters),
* regexp (wrapper for '_random-string_' library),
* number (random number form provided range).

By design, library can be used to create data for chosen locale.

**Notice:** Currently, only Polish locale is supported.

### Installation (easy way)
The easiest way to install DataGenerator is by using  **jitpack.io** (https://jitpack.io/) library, which allows adding **GitHub** project as a dependency (inside maven, gradle, sbt or leiningen) configuration file.

Simple configuration for maven **pom.xml** file could look as below:
```
(...)
	<repositories>
		<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependencies>
		<dependency>
		<groupId>com.github.PawelWorwa</groupId>
		<artifactId>DataGenerator</artifactId>
		<version>2.0.1</version>
		</dependency>
	</dependencies>
(...)
```

### Usage
Simple usage could look as below:
```
// create DataGenerator instance
DataGenerator generator = new DataGenerator("pl"); // 'pl' locale is currently by default

// use it ;-)
```
<br/><br/>
Generating company data:
```
generator.company().name();                    // sample output: Progressive Solutions
generator.company().longRegistrationNumber();  // sample output: 16033258045340
generator.company().registrationNumber();      // sample output: 302835165
generator.company().shortRegistrationNumber(); // sample output: 248779126
generator.company().vatIdentificationNumber(); // sample output: 2726899545
```
<br/><br/>
Generating peron data (the same applies for '*generator.person().female()*'):
```
int age = 18; 
generator.person().male().isMale();           // sample output: true
generator.person().male().isFemale();         // sample output: false
generator.person().male().birthDate();        // sample output: 1998-04-13
generator.person().male().birthDate(int age); // sample output: 2002-07-24
generator.person().male().firstName();        // sample output: Krystian
generator.person().male().lastName();         // sample output: Ziółkowski
generator.person().male().ssnNumber();        // sample output: 67042624656
generator.person().male().ssnNumber(int age); // sample output: 02211557298
```
<br/><br/>
Generating address:
```
generator.address().areaCode();    // sample output: 25
generator.address().city();        // sample output: Siedlce
generator.address().flatNumber();  // sample output: 82
generator.address().houseNumber(); // sample output: 95
generator.address().state();       // sample output: Mazowieckie
generator.address().street();      // sample output: ul. Tadeusza Zieleniewskiego
```
Keep in mind though that address information's are linked, so to create new random values,
another instance of DataGenerator is needed.

<br/><br/>
Phone number:
```
generator.phoneNumber().countryCode();         // sample output: +48
generator.phoneNumber().mobilePhoneNumber();   // sample output: 232940655
generator.phoneNumber().phoneNumber();         // sample output: 167125037
generator.phoneNumber().phoneNumber(areaCode); // sample output: 223642286
```

### Additional features
Random number from regexp expression (wrapper for _'random-string'_ library):
```
generator.regexp().randomStringFromRegexp(String regexp)
```

<br/><br/>
Lorem ipsum sentence:
```
generator.loremIpsum().defaultSentence(); // sample output: Lorem ipsum dolor sit amet.
generator.loremIpsum().createWords(long words);
generator.loremIpsum().createParagraphs(int paragraphs, int minWordsPerParagraph, int maxWordsPerParagraph); 
```

<br/><br/>
Random number:
```
generator.number().randomNumber(int min, int max);
generator.number().randomNumber(int max); // min is 0 by default
```

### License
This project is licensed under the GNU General Public License - see the LICENSE file for details