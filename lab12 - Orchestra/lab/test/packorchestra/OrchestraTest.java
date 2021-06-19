package packorchestra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import packmusician.*;

class OrchestraTest {
	Orchestra orchestra;
	Musician musician;
	
	@BeforeEach
	void setUp() throws Exception {
		orchestra = new Orchestra("orchestra1");
	}

	@Test
	void testGetFee0Musicians() {
		assertEquals(orchestra.getFee(), 0);
	}
	
	@Test
	void testGetFee1Musician() {
		musician = new Musician("musician1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Director() {
		musician = new Director("director1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Singer() {
		musician = new Singer("singer1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Soprano() {
		musician = new Soprano("soprano1", true);
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Tenor() {
		musician = new Tenor("tenor1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Instrumentalist() {
		musician = new Instrumentalist("instrumentalist1", "instrument1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Pianist() {
		musician = new Pianist("pianist1");
		orchestra.hire(musician);
		
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@Test
	void testGetFee1Trumpeter() {
		musician = new Trumpeter("trumpeter");
		orchestra.hire(musician);
		assertEquals(orchestra.getFee(), musician.getSalary());
	}
	
	@DisplayName("Fee of an orchestra with one component of each type of musician")
	@Test
	void testGetFee1OfEveryMusician() {
		Musician[] musicians = new Musician[8];
		double allSalaries = 0;
		
		musicians[0] = new Musician("musician1");
		musicians[1] = new Director("director1");
		musicians[2] = new Singer("singer1");
		musicians[3] = new Tenor("tenor1");
		musicians[7] = new Soprano("soprano1", true);
		musicians[4] = new Instrumentalist("instrumentalist1", "instrument1");
		musicians[5] = new Pianist("pianist1");
		musicians[6] = new Trumpeter("trumpeter1");
		
		for (Musician musician: musicians) {
			orchestra.hire(musician);
			allSalaries += musician.getSalary();
		}
		
		assertEquals(orchestra.getFee(), allSalaries);
		
	}
}
