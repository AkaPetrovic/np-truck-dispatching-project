package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TruckTypeTest {

	private TruckType tt;
	
	@BeforeEach
	void setUp() throws Exception {
		tt = new TruckType();
	}

	@AfterEach
	void tearDown() throws Exception {
		tt = null;
	}

	@Test
	void testSetId() {
		tt.setId(5L);
		assertEquals(5L, tt.getId());
	}
	
	@Test
	void testSetName() {
		tt.setName("Type");
		assertEquals("Type", tt.getName());
	}
	
	@Test
	void testToString() {
		tt.setId(5L);
		tt.setName("Type");
		
		assertEquals("Type", tt.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, Type1, 1, Type1, true",
		"1, Type1, 1, Type2, false",
		"1, Type1, 2, Type1, false"
	})
	void testEquals(Long id1, String name1, Long id2, String name2, boolean same) {
		tt.setId(id1);
		tt.setName(name1);
		
		TruckType tt2 = new TruckType();
		
		tt2.setId(id2);
		tt2.setName(name2);
		
		assertEquals(same, tt.equals(tt2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(tt.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(tt.equals(tt));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(tt.equals(new Exception()));
	}

}
