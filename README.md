# DataGenerator Library
## Basic information
After couple of test project's using Selenium Webdriver I've noticed, that I'm implementing several methods used for data generation over and over again. I've fought *wouldyn't it be nice and easier to have them implemented once inside external library?*. It would...

I've done some research and found couple of good sites that enabled generation of required data. Those pages had an downside though - data was provided only by web page and therefore, unusable(inaccessible) from tests without external input files.

To My wonder, I was unable to find and library that could be included within Selenium project. Because I'm a little bit tired from reimplementing those methods over and over again... I've created My own library that enables:
* generation of PESEL number (both male and female) for provided age;
* generation of ID card number;
* generation of NIP number;
* generation of REGON, both short (nine digits) and long (twelve digits) one;
* generation of commonly used in Poland male and female names with surnames.

** Limitations **
All algorithms and names used within this library are designed for Poland.

## Installation - easy way
Easiest way of installation for DataGenerator is by using **jitpack.io** (https://jitpack.io/) library, which enables to add **GitHub** project as a dependency inside maven’s (or gradle or whatever) configuration file.

Simple (and minimal) configuration for maven **pom.xml** file could look as below:
```
<modelVersion>4.0.0</modelVersion>
	<groupId>SampleScript</groupId>
	<artifactId>SampleScript</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name> SampleScript </name>
	<url>http://maven.apache.org</url>
	
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
		    <version>1.0.0</version>
		</dependency>
	</dependencies>
</project>
```

And that’s it.


## Installation - long way
If it’s not possible to get DataGenerator library through **jitpack.io** (whatever the reason), DataGenerator library still can be obtained in two ways, either by:
* including it inside a each project, where data generation is necessary;
* installing in local **maven** repository and using through **pom.xml** file.

First approach is much straightforward and IDE dependant. Second one thought, needs a little bit more explanation.

**Add jar to local maven repository**
From command line type:
```
mvn install:install-file -Dfile=**<JAR_FILE_PATH>** -DgroupId=pl.data.generator -DartifactId=dataGenerator -Dversion=1.0.0 -Dpackaging=jar
```

For `-Dversion` parameter provide required version.

**Maven dependency**
Inside project **pom.xml** file, add below dependency:
```
<dependency>
	<groupId>pl.data.generator</groupId>
	<artifactId>dataGenerator</artifactId>
	<version>1.0.0</version>
</dependency>
```

Again, inside `<version \>` headers, valid version number needs to be provided.

## Usage
DataGenerator is a static class (more precisely, final class with static methods), therefore it's unnecessary to create class object. 
To gain access for desired methods, simply type class name: `DataGenerator` and select required generator. Each method return's String variable.

### Generate card id number
Card id number is accessed by `DataGenerator.generateCardIDnumber();` statement. 
Used algorithm for ID card number can be found here: [Polish identity card](https://en.wikipedia.org/wiki/Polish_identity_card/).

**Sample usage:**
```
	@Test
	public void createCustomer() {
		//Before test Steps
		String idCardNumber = DataGenerator.generateCardIDnumber();
		//After test steps
	}
```

### Generate PESEL number
PESEL(letters stand from: *Powszechny Elektroniczny Spis Ewidencji Ludności - Universal Electronic Population Database*) number is generated seperatly for Male and Female as their algorithms differ. 

Additionaly, to avoid creating seperated methods for adults and child, each of of them needs to be provided with `age` parameter. PESEL number is being calculated then as follows: *Current date* minus *age parameter* equals *calculated birth date*. 

So in the end, creation for either adult or child PESEL number, is basing only on privided parameter.
Used algorithm for PESEL number can be found here: [Polish PESEL number](https://en.wikipedia.org/wiki/PESEL/).

**Available methods**
* `DataGenerator.generatePesel(age);` - for random (male or female) PESEL;
* `DataGenerator.generateMalePesel(age);` - for male PESEL;
* `DataGenerator.generateFemalePesel(age);` - for female PESEL.

**Sample usage:**
```
	@Test
	public void usePESELnumbers() {
		//(...)
		int adultYears = 35;
		String randomAdultPESEL = DataGenerator.generatePesel(adultYears);
		//(...)
		int childYears = 5;
		String childPESEL = DataGenerator.generateMalePesel(childYears);
		//(...)
		int oldAdultYears = 80;
		String oldLadyPESEL = DataGenerator.generateFemalePesel(oldAdultYears);
		//(...)
	}
```

### Generate User name
Sometimes during test runs, We need to provide real names, not just the ones including "random characters". Methods grouped within this category are used for that purpose, providing:
* `DataGenerator.generateMaleName();` - for random male name used in Poland;
* `DataGenerator.generateFemaleName();` - for random female name used in Poland;
* `DataGenerator.generateSurname();` - for random common surname used in Poland.

**Sample usage:**
```
	@Test
	public void createUserName() {
		//(...)
		String randomMaleName= DataGenerator.generateMaleName();
		//(...)
		String randomFealeName = DataGenerator.generateFemaleName();
		//(...)
		String randomSurname = DataGenerator.generateSurname();
		String wholeName = randomMaleName + " " + randomSurname;
		//(...)
	}
```

### Generate REGON
For REGON (statistical) numbers generations, there are two seperate methods:
* `DataGenerator.generateShortRegon();` - for nine digit number;
* `DataGenerator.generateLongRegon();` - for twelve digit number;

Since I couldyn't find good description for algorithm used in English, below short description:

Each REGON number except last digit, that is reserved for checksum is multiplied by weights and sum up. After this, result for modulo 11 operation is being performed. If result equals 10, then checksum is 0. For other results, rest from modulo operation is checksum (last REGON digit).

**Weights used:**
* 89234567 - for short number; 
* 2485097361248 - for long number;
 
**Sample usage:**
```
	@Test
	public void generateREGONnumbers() {
		//(...)
		String shortRegon = DataGenerator.generateShortRegon();
		//(...)
		String longRegon = DataGenerator.generateLongRegon();
		//(...)
	}
```

### Generate NIP
Least but not last comes NIP (tax identification) number accessed by `DataGenerator.generateNIP();` method. Once again I was unable to find good algorithm description in English, used algorithm mechanism below:

Idea is the same as in REGON, each digit is being multiplied by weights and sum up. After this, rest from modulo 11 for sum result operation is treated as checksum and last NIP digit. If result equals zero, NIP is treated as invalid and regenerated. 

**Weights used:**
* 657234567.

**Sample usage:**
```
	@Test
	public void generateNIPnumber() {
		//(...)
		String NIPnumber= DataGenerator.generateNIP();
		//(...)
	}
```