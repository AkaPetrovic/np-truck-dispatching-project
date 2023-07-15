package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DriverTest {

	private Driver d;
	
	@BeforeEach
	void setUp() throws Exception {
		d = new Driver();
	}

	@AfterEach
	void tearDown() throws Exception {
		d = null;
	}

	@Test
	void testSetId() {
		d.setId(5L);
		assertEquals(5L, d.getId());
	}
	
	@Test
	void testSetName() {
		d.setName("Name");
		assertEquals("Name", d.getName());
	}
	
	@Test
	void testSetSurname() {
		d.setSurname("Surname");
		assertEquals("Surname", d.getSurname());
	}
	
	@Test
	void testSetBirthday() {
		int year = 1992;
        int month = 6;
        int day = 7;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        Date birthday = calendar.getTime();
		d.setBirthday(birthday);
		
		assertEquals(birthday, d.getBirthday());
	}
	
	@Test
	void testSetTruck() {
		Country truckManufacturerCountryOfOrigin = new Country(3L, "Sweden");
		Manufacturer truckManufacturer = new Manufacturer(2L, "Scania", truckManufacturerCountryOfOrigin);
		TruckType truckType = new TruckType(3L, "Large");
		
		Truck truck = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer,
								truckType);
		
		d.setTruck(truck);
		assertEquals(truck, d.getTruck());
	}
	
	@Test
	void testToString() {
		int year = 1992;
        int month = 6;
        int day = 7;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        Date birthday = calendar.getTime();
		
        
        
		Country truckManufacturerCountryOfOrigin = new Country(3L, "Sweden");
		Manufacturer truckManufacturer = new Manufacturer(2L, "Scania", truckManufacturerCountryOfOrigin);
		TruckType truckType = new TruckType(3L, "Large");
		
		Truck truck = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer,
								truckType);
		
		
		
		d.setId(5L);
		d.setName("Name");
		d.setSurname("Surname");
		d.setBirthday(birthday);
		d.setTruck(truck);
		
		String s = d.toString();
		
		assertEquals("5 | Name Surname | Birthday: 07.07.1992. // Truck: Scania (Sweden) Citywide LF", s);
	}

	@ParameterizedTest
	@CsvSource ({
		"1, Pera, Peric, 1, Pera, Peric, true",
		"1, Pera, Peric, 1, Pera, Pericc, false",
		"1, Pera, Peric, 1, Peraa, Peric, false",
		"1, Pera, Peric, 2, Pera, Peric, false"
	})
	void testEquals(Long id1, String name1, String surname1, Long id2, String name2, String surname2, boolean same) {
		d.setId(id1);
		d.setName(name1);
		d.setSurname(surname1);
		
		Driver d2 = new Driver();
		
		d2.setId(id2);
		d2.setName(name2);
		d2.setSurname(surname2);
		
		assertEquals(same, d.equals(d2));
	}
	
	@Test
	void testEqualsBirthdaySame() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		int year = 1992;
        int month = 6;
        int day = 7;

        calendar.set(year, month, day);

        Date birthday = calendar.getTime();
        
        d.setBirthday(birthday);
        
        
        
        int year2 = 1992;
        int month2 = 6;
        int day2 = 7;

        calendar.set(year2, month2, day2);

        Date birthday2 = calendar.getTime();
        
        Driver d2 = new Driver();
        d2.setBirthday(birthday2);
        
        
        
        assertTrue(d.equals(d2));
	}
	
	@Test
	void testEqualsBirthdayDifferent() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		int year = 1992;
        int month = 6;
        int day = 7;

        calendar.set(year, month, day);

        Date birthday = calendar.getTime();
        
        d.setBirthday(birthday);
        
        
        
        int year2 = 1993;
        int month2 = 6;
        int day2 = 7;

        calendar.set(year2, month2, day2);

        Date birthday2 = calendar.getTime();
        
        Driver d2 = new Driver();
        d2.setBirthday(birthday2);
        
        
        
        assertFalse(d.equals(d2));
	}
	
	@Test
	void testEqualsTruckSame() {
		Country truckManufacturerCountryOfOrigin = new Country(3L, "Sweden");
		Manufacturer truckManufacturer = new Manufacturer(2L, "Scania", truckManufacturerCountryOfOrigin);
		TruckType truckType = new TruckType(3L, "Large");
		
		Truck truck = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer,
								truckType);
		
        d.setTruck(truck);
        
        
        
        Country truckManufacturerCountryOfOrigin2 = new Country(3L, "Sweden");
		Manufacturer truckManufacturer2 = new Manufacturer(2L, "Scania", truckManufacturerCountryOfOrigin2);
		TruckType truckType2 = new TruckType(3L, "Large");
		
		Truck truck2 = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer2,
								truckType2);
        
        Driver d2 = new Driver();
        d2.setTruck(truck2);
        
        
        
        assertTrue(d.equals(d2));
	}
	
	@Test
	void testEqualsTruckDifferent() {
		Country truckManufacturerCountryOfOrigin = new Country(3L, "Sweden");
		Manufacturer truckManufacturer = new Manufacturer(2L, "Scania", truckManufacturerCountryOfOrigin);
		TruckType truckType = new TruckType(3L, "Large");
		
		Truck truck = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer,
								truckType);
		
        d.setTruck(truck);
        
        
        
        Country truckManufacturerCountryOfOrigin2 = new Country(2L, "Sweden");
		Manufacturer truckManufacturer2 = new Manufacturer(4L, "Scania", truckManufacturerCountryOfOrigin2);
		TruckType truckType2 = new TruckType(2L, "Large");
		
		Truck truck2 = new Truck(1L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer2,
								truckType2);
        
        Driver d2 = new Driver();
        d2.setTruck(truck2);
        
        
        
        assertFalse(d.equals(d2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(d.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(d.equals(d));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(d.equals(new Exception()));
	}
}
