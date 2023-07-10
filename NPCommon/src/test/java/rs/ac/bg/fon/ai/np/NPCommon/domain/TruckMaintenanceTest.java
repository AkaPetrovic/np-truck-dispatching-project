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

public class TruckMaintenanceTest {

	private TruckMaintenance tm;
	
	@BeforeEach
	void setUp() throws Exception {
		tm = new TruckMaintenance();
	}

	@AfterEach
	void tearDown() throws Exception {
		tm = null;
	}

	@Test
	void testSetId() {
		tm.setId(5L);
		assertEquals(5L, tm.getId());
	}
	
	@Test
	void testSetDateOfService() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2023, 6, 15);
        Date dateOfService = calendar.getTime();
		
        tm.setDateOfService(dateOfService);
		assertEquals(dateOfService, tm.getDateOfService());
	}
	
	@Test
	void testSetKmAtService() {
		tm.setKmAtService(new BigDecimal(134532.23));
		assertEquals(new BigDecimal(134532.23), tm.getKmAtService());
	}
	
	@Test
	void testSetTruck() {
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		tm.setTruck(truck);
		
		
		
		assertEquals(truck, tm.getTruck());
	}
	
	@Test
	void testToString() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		tm.setId(5L);
		
		calendar.set(2023, 6, 15);
        Date dateOfService = calendar.getTime();
        tm.setDateOfService(dateOfService);
        
        tm.setKmAtService(new BigDecimal(134532.23));
		
        
        
        Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		tm.setTruck(truck);
		
		
		
		assertEquals("5 | Truck: 2 | Scania (Sweden) 560R | Year: 2004 | Power: 500 HP | Type: Medium | Carrying capacity: 67,45 | KM travelled: 132503,52 | Date of service: 15.07.2023. | KM at service: 134532.23000000001047737896442413330078125", tm.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, 134532.23, 1, 134532.23, true",
		"1, 134532.23, 1, 234532.23, false",
		"1, 134532.23, 2, 134532.23, false"
	})
	void testEquals(Long id1, BigDecimal kmAtService1, Long id2, BigDecimal kmAtService2, boolean same) {
		tm.setId(id1);
		tm.setKmAtService(kmAtService1);
		
		TruckMaintenance tm2 = new TruckMaintenance();
		
		tm2.setId(id2);
		tm2.setKmAtService(kmAtService2);
		
		assertEquals(same, tm.equals(tm2));
	}
	
	@Test
	void testEqualsDateOfServiceSame() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 6, 15);
        Date dateOfService = calendar.getTime();
        tm.setDateOfService(dateOfService);

        TruckMaintenance tm2 = new TruckMaintenance();
        
        calendar.set(2023, 6, 15);
        Date dateOfService2 = calendar.getTime();
        tm2.setDateOfService(dateOfService2);
        
        
        
        assertTrue(tm.equals(tm2));
	}
	
	@Test
	void testEqualsDateOfServiceDifferent() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 6, 15);
        Date dateOfService = calendar.getTime();
        tm.setDateOfService(dateOfService);

        TruckMaintenance tm2 = new TruckMaintenance();
        
        calendar.set(2023, 7, 26);
        Date dateOfService2 = calendar.getTime();
        tm2.setDateOfService(dateOfService2);
        
        
        
        assertFalse(tm.equals(tm2));
	}
	
	@Test
	void testEqualsTruckSame() {
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		tm.setTruck(truck);

		
		
        TruckMaintenance tm2 = new TruckMaintenance();
        
        Country country2 = new Country(4L, "Sweden");
		
		Manufacturer manufacturer2 = new Manufacturer(4L, "Scania", country2);
		TruckType truckType2 = new TruckType(3L, "Medium");
		
		Truck truck2 = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer2, truckType2);
		
		tm2.setTruck(truck2);
        
        
        
        assertTrue(tm.equals(tm2));
	}
	
	@Test
	void testEqualsTruckDifferent() {
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		tm.setTruck(truck);

		
		
        TruckMaintenance tm2 = new TruckMaintenance();
        
        Country country2 = new Country(5L, "Sweden");
		
		Manufacturer manufacturer2 = new Manufacturer(5L, "Scania", country2);
		TruckType truckType2 = new TruckType(2L, "Medium");
		
		Truck truck2 = new Truck(3L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer2, truckType2);
		
		tm2.setTruck(truck2);
        
        
        
        assertFalse(tm.equals(tm2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(tm.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(tm.equals(tm));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(tm.equals(new Exception()));
	}

}
