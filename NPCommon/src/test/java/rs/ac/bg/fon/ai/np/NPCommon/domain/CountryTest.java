package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountryTest {

	private Country c;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Country();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	void testSetId() {
		c.setId(5L);
		assertEquals(5, c.getId());
	}

	@Test
	void testSetName() {
		c.setName("Serbia");
		assertEquals("Serbia", c.getName());
	}
	
	@Test
	void testToString() {
		c.setName("Serbia");
		
		String s = c.toString();
		
		assertTrue(s.contains("Serbia"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, Serbia, 1, Serbia, true",
		"1, Serbia, 1, Serbiaa, false",
		"1, Serbia, 2, Serbia, false"
	})
	void testEquals(Long id1, String name1, Long id2, String name2, boolean same) {
		c.setId(id1);
		c.setName(name1);
		
		Country c2 = new Country();
		
		c2.setId(id2);
		c2.setName(name2);
		
		assertEquals(same, c.equals(c2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(c.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(c.equals(c));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(c.equals(new Exception()));
	}
}
