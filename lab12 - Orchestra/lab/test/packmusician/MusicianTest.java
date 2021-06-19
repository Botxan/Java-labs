package packmusician;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MusicianTest {
	Musician musician;
	@BeforeEach
	void setUp() throws Exception {	
	}

	@Test
	void testPerform() {
		musician = new Musician("musician1");
		assertEquals("ssssss", musician.perform());
	}
	
	@DisplayName("Test hire method for already hired musician")
	@Test
	void testHiredNotHiredYet() {
		musician = new Musician("musician1");
		try {
			musician.hire();
		} catch (AlreadyHiredMusician e) {
			fail("(Unexpected) " + e.getMessage());
		}	
		assertTrue(musician.isHired());
	}
	
	@DisplayName("Test hire method for musician that is not hired yet")
	@Test
	void testHiredAleradyHired() {
		musician = new Musician("musician1");
		try {
			musician.hire();
		} catch (AlreadyHiredMusician e) {
			fail("(Unexpected) " + e.getMessage());
		}
		assertThrows(AlreadyHiredMusician.class, () -> musician.hire());
	}
	
	@Test
	void performMusician() {
		musician = new Musician("musician1");
		assertEquals(musician.perform(), "ssssss");
	}
	
	@Test
	void performDirector() {
		musician = new Director("director1");
		assertEquals(musician.perform(), "Tok tok tok: (silence)");
	}
	
	@Test
	void performSinger() {
		musician = new Singer("singer1");
		assertEquals(musician.perform(), "ssssss");
	}
	
	@Test
	void performTenor() {
		musician = new Tenor("tenor1");
		assertEquals(musician.perform(), "La-la-la-laaaaaaa");
	}
	
	@Test
	void performSoprano() {
		musician = new Soprano("soprano1", true);
		assertEquals(musician.perform(), "Li-li-li-liiiiiiiii");
	}
	
	@Test
	void performInstrumentalist() {
		musician = new Instrumentalist("instrumentalist1", "instrument1");
		assertEquals(musician.perform(), "ssssss");
	}
	
	@Test
	void performPianist() {
		musician = new Pianist("pianist1");
		assertEquals(musician.perform(), "Ding-ting-dang-ding-tang-ting");
	}
	
	@Test
	void performTrumpeter() {
		musician = new Trumpeter("trumpeter1");
		assertEquals(musician.perform(), "Tu-ru-ru-tu-ru-ru");
	}
}
