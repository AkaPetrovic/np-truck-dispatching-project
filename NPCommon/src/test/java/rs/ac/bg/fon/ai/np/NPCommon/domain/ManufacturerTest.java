package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ManufacturerTest {

	private Manufacturer m;
	
	@BeforeEach
	void setUp() throws Exception {
		m = new Manufacturer();
	}

	@AfterEach
	void tearDown() throws Exception {
		m = null;
	}

	@Test
	void testSetId() {
		m.setId(4L);
		assertEquals(4L, m.getId());
	}
	
	@Test
	void testSetIdNull() {
		assertThrows(NullPointerException.class, () -> m.setId(null));
	}
	
	@Test
	void testSetIdLessThan1() {
		assertThrows(IllegalArgumentException.class, () -> m.setId(0L));
	}
	
	@Test
	void testSetName() {
		m.setName("Scania");
		assertEquals("Scania", m.getName());
	}
	
	@Test
	void testSetNameNull() {
		assertThrows(NullPointerException.class, () -> m.setName(null));
	}
	
	@Test
	void testSetNameEmptyString() {
		assertThrows(IllegalArgumentException.class, () -> m.setName(""));
	}
	
	@Test
	void testSetCountry() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		
		m.setCountry(manufacturerCountry);
		assertEquals(manufacturerCountry, m.getCountry());
	}
	
	@Test
	void testSetCountryNull() {
		assertThrows(NullPointerException.class, () -> m.setCountry(null));
	}
	
	@Test
	void testToString() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		
		m.setId(4L);
		m.setName("Scania");
		m.setCountry(manufacturerCountry);
		
		assertEquals("Scania (Sweden)", m.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, Scania, 1, Scania, true",
		"1, Scania, 1, Volvo, false",
		"1, Scania, 2, Scania, false"
	})
	void testEquals(Long id1, String name1, Long id2, String name2, boolean same) {
		m.setId(id1);
		m.setName(name1);
		
		Manufacturer m2 = new Manufacturer();
		
		m2.setId(id2);
		m2.setName(name2);
		
		assertEquals(same, m.equals(m2));
	}
	
	@Test
	void testEqualsCountrySame() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		
		m.setCountry(manufacturerCountry);

		Country manufacturerCountry2 = new Country(3L, "Sweden");
        
		Manufacturer m2 = new Manufacturer();
		m2.setCountry(manufacturerCountry2);
        
        assertTrue(m.equals(m2));
	}
	
	@Test
	void testEqualsCountryDifferent() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		
		m.setCountry(manufacturerCountry);

		Country manufacturerCountry2 = new Country(4L, "Spain");
        
		Manufacturer m2 = new Manufacturer();
		m2.setCountry(manufacturerCountry2);
        
        assertFalse(m.equals(m2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(m.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(m.equals(m));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(m.equals(new Exception()));
	}

}
