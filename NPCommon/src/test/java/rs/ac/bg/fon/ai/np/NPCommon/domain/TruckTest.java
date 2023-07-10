package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TruckTest {

	private Truck t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new Truck();
	}

	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@Test
	void testSetId() {
		t.setId(4L);
		assertEquals(4L, t.getId());
	}
	
	@Test
	void testSetModel() {
		t.setModel("560R");
		assertEquals("560R", t.getModel());
	}
	
	@Test
	void testSetPower() {
		t.setPower(500);
		assertEquals(500, t.getPower());
	}
	
	@Test
	void testSetKmTravelled() {
		t.setKmTravelled(new BigDecimal(132120.54));
		assertEquals(new BigDecimal(132120.54), t.getKmTravelled());
	}
	
	@Test
	void testSetYear() {
		t.setYear(2002);
		assertEquals(2002, t.getYear());
	}

	@Test
	void testSetCarryingCapacity() {
		t.setCarryingCapacity(new BigDecimal(60.5));
		assertEquals(new BigDecimal(60.5), t.getCarryingCapacity());
	}
	
	@Test
	void testSetManufacturer() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		Manufacturer manufacturer = new Manufacturer(2L, "Scania", manufacturerCountry);
		
		t.setManufacturer(manufacturer);
		
		assertEquals(manufacturer, t.getManufacturer());
	}
	
	@Test
	void testSetTruckType() {
		TruckType truckType = new TruckType(4L, "Large");
		
		t.setTruckType(truckType);
		
		assertEquals(truckType, t.getTruckType());
	}
	
	@Test
	void testToString() {
		TruckType truckType = new TruckType(4L, "Large");
		
		Country manufacturerCountry = new Country(3L, "Sweden");
		Manufacturer manufacturer = new Manufacturer(2L, "Scania", manufacturerCountry);
		
		t.setTruckType(truckType);
		t.setManufacturer(manufacturer);
		t.setYear(2002);
		t.setId(4L);
		t.setModel("560R");
		t.setPower(500);
		t.setCarryingCapacity(new BigDecimal(60.5));
		t.setKmTravelled(new BigDecimal(132120.54));
		
		assertEquals("4 | Scania (Sweden) 560R | Year: 2002 | Power: 500 HP | Type: Large | Carrying capacity: 60,5 | KM travelled: 132120,54", t.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2002, 560R, 500, 60.5, 132120.54, true",
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2002, 560R, 500, 60.5, 232120.54, false",
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2002, 560R, 500, 65.5, 132120.54, false",
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2002, 560R, 600, 60.5, 132120.54, false",
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2002, 760R, 500, 60.5, 132120.54, false",
		"4, 2002, 560R, 500, 60.5, 132120.54, 4, 2005, 560R, 500, 60.5, 132120.54, false",
		"4, 2002, 560R, 500, 60.5, 132120.54, 3, 2002, 560R, 500, 60.5, 132120.54, false",
	})
	void testEquals(Long id1, int year1, String model1, int power1, BigDecimal carryingCapacity1, BigDecimal kmTravelled1, Long id2, int year2, String model2, int power2, BigDecimal carryingCapacity2, BigDecimal kmTravelled2, boolean same) {
		t.setId(id1);
		t.setYear(year1);
		t.setModel(model1);
		t.setPower(power1);
		t.setCarryingCapacity(carryingCapacity1);
		t.setKmTravelled(kmTravelled1);
		
		Truck t2 = new Truck();
		
		t2.setId(id2);
		t2.setYear(year2);
		t2.setModel(model2);
		t2.setPower(power2);
		t2.setCarryingCapacity(carryingCapacity2);
		t2.setKmTravelled(kmTravelled2);
		
		assertEquals(same, t.equals(t2));
	}
	
	@Test
	void testEqualsManufacturerSame() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		Manufacturer manufacturer = new Manufacturer(2L, "Scania", manufacturerCountry);
		
		t.setManufacturer(manufacturer);
        
		Country manufacturerCountry2 = new Country(3L, "Sweden");
		Manufacturer manufacturer2 = new Manufacturer(2L, "Scania", manufacturerCountry);
		
		Truck t2 = new Truck();
		
		t2.setManufacturer(manufacturer2);
        
        assertTrue(t.equals(t2));
	}
	
	@Test
	void testEqualsManufacturerDifferent() {
		Country manufacturerCountry = new Country(3L, "Sweden");
		Manufacturer manufacturer = new Manufacturer(2L, "Scania", manufacturerCountry);
		
		t.setManufacturer(manufacturer);
        
		Country manufacturerCountry2 = new Country(5L, "Sweden");
		Manufacturer manufacturer2 = new Manufacturer(4L, "Volvo", manufacturerCountry2);
		
		Truck t2 = new Truck();
		
		t2.setManufacturer(manufacturer2);
        
        assertFalse(t.equals(t2));
	}
	
	@Test
	void testEqualsTruckTypeSame() {
		TruckType truckType = new TruckType(4L, "Large");
		
		t.setTruckType(truckType);
        
		TruckType truckType2 = new TruckType(4L, "Large");
		
		Truck t2 = new Truck();
		
		t2.setTruckType(truckType2);
        
        assertTrue(t.equals(t2));
	}
	
	@Test
	void testEqualsTruckTypeDifferent() {
		TruckType truckType = new TruckType(4L, "Large");
		
		t.setTruckType(truckType);
        
		TruckType truckType2 = new TruckType(3L, "Medium");
		
		Truck t2 = new Truck();
		
		t2.setTruckType(truckType2);
        
        assertFalse(t.equals(t2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(t.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(t.equals(t));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(t.equals(new Exception()));
	}
	
}
