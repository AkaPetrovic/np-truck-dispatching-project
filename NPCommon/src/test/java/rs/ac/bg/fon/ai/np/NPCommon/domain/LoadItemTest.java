package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;

public class LoadItemTest {

	private LoadItem li;
	
	@BeforeEach
	void setUp() throws Exception {
		li = new LoadItem();
	}

	@AfterEach
	void tearDown() throws Exception {
		li = null;
	}

	@Test
	void testSetId() {
		li.setId(5L);
		assertEquals(5L, li.getId());
	}
	
	@Test
	void testSetTruckLoad() {
		Calendar calendar = Calendar.getInstance();
		
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
		
		calendar.set(1992, 6, 23);
		Date birthday = calendar.getTime();
		Driver driver = new Driver(4L, "Name", "Surname", birthday, truck);
		
		calendar.set(2023, 6, 15);
		Date departureDate = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate = calendar.getTime();
		
		LocalTime departureTime = LocalTime.of(10, 15);
		LocalTime arrivalTime = LocalTime.of(16, 35);
		
		TruckLoad load = new TruckLoad(12L, departureDate, arrivalDate, departureTime, arrivalTime, new BigDecimal(2.46), driver);
		
		
		
		li.setLoad(load);
		assertEquals(load, li.getLoad());
	}

	@Test
	void testSetLoadItemName() {
		li.setLoadItemName("Chair");
		assertEquals("Chair", li.getLoadItemName());
	}
	
	@Test
	void testSetIsDangerous() {
		li.setIsDangerous(true);
		assertEquals(true, li.isDangerous());
	}
	
	@Test
	void testSetIsFragile() {
		li.setIsFragile(false);
		assertEquals(false, li.isFragile());
	}
	
	@Test
	void testSetWeight() {
		li.setWeight(new BigDecimal(123.12));
		assertEquals(new BigDecimal(123.12), li.getWeight());
	}
	
	@Test
	void testSetVolume() {
		li.setVolume(new BigDecimal(3.5));
		assertEquals(new BigDecimal(3.5), li.getVolume());
	}
	
	@Test
	void testSetLoadItemState() {
		li.setState(LoadItemState.INSERT);
		assertEquals(LoadItemState.INSERT, li.getState());
	}
	
	@Test
	void testSetPreviousId() {
		li.setPreviousId(3L);
		assertEquals(3L, li.getPreviousId());
	}
	
	@Test
	void testToString() {
		Calendar calendar = Calendar.getInstance();
		
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
		
		calendar.set(1992, 6, 23);
		Date birthday = calendar.getTime();
		Driver driver = new Driver(4L, "Name", "Surname", birthday, truck);
		
		calendar.set(2023, 6, 15);
		Date departureDate = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate = calendar.getTime();
		
		LocalTime departureTime = LocalTime.of(10, 15);
		LocalTime arrivalTime = LocalTime.of(16, 35);
		
		TruckLoad load = new TruckLoad(12L, departureDate, arrivalDate, departureTime, arrivalTime, new BigDecimal(2.46), driver);
		
		
		
		li.setId(1L);
		li.setLoad(load);
		li.setLoadItemName("Chair");
		li.setIsDangerous(false);
		li.setIsFragile(true);
		li.setState(LoadItemState.DELETE);
		li.setVolume(new BigDecimal(3.2));
		li.setWeight(new BigDecimal(15.4));
		
		String s = li.toString();
		
		assertTrue(s.contains("1"));
		assertTrue(s.contains("Chair"));
		assertTrue(s.contains("dangerous=false"));
		assertTrue(s.contains("fragile=true"));
		assertTrue(s.contains("state=DELETE"));
		assertTrue(s.contains("volume=3"));
		assertTrue(s.contains("weight=15"));
		assertTrue(s.contains("load=12 | Departure date: 15.07.2023. | Arrival date: 16.07.2023. | Departure time: 10:15 | Arrival time: 16:35"));
		assertTrue(s.contains("Driver: Name Surname"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"false, true, Chair, 52.32, 1.62, false, true, Chair, 52.32, 1.62, true",
		"false, true, Chair, 52.32, 1.62, false, true, Chair, 52.32, 1.72, false",
		"false, true, Chair, 52.32, 1.62, false, true, Chair, 42.32, 1.62, false",
		"false, true, Chair, 52.32, 1.62, false, true, Chairs, 52.32, 1.62, false",
		"false, true, Chair, 52.32, 1.62, false, false, Chair, 52.32, 1.62, false",
		"false, true, Chair, 52.32, 1.62, true, true, Chair, 52.32, 1.62, false"
	})
	void testEquals(boolean dangerous1, boolean fragile1, String loadItemName1, BigDecimal weight1, BigDecimal volume1, boolean dangerous2, boolean fragile2, String loadItemName2, BigDecimal weight2, BigDecimal volume2, boolean same) {
		li.setIsDangerous(dangerous1);
		li.setIsFragile(fragile1);
		li.setLoadItemName(loadItemName1);
		li.setWeight(weight1);
		li.setVolume(volume1);
		
		LoadItem li2 = new LoadItem();
		
		li2.setIsDangerous(dangerous2);
		li2.setIsFragile(fragile2);
		li2.setLoadItemName(loadItemName2);
		li2.setWeight(weight2);
		li2.setVolume(volume2);
		
		assertEquals(same, li.equals(li2));
	}
	
	@Test
	void testEqualsTruckLoadSame() {
		Calendar calendar = Calendar.getInstance();
		
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
		
		calendar.set(1992, 6, 23);
		Date birthday = calendar.getTime();
		Driver driver = new Driver(4L, "Name", "Surname", birthday, truck);
		
		calendar.set(2023, 6, 15);
		Date departureDate = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate = calendar.getTime();
		
		LocalTime departureTime = LocalTime.of(10, 15);
		LocalTime arrivalTime = LocalTime.of(16, 35);
		
		TruckLoad load = new TruckLoad(12L, departureDate, arrivalDate, departureTime, arrivalTime, new BigDecimal(2.46), driver);
		
        li.setLoad(load);
        
        
        
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
		
		calendar.set(1992, 6, 23);
		Date birthday2 = calendar.getTime();
		Driver driver2 = new Driver(4L, "Name", "Surname", birthday2, truck2);
		
		calendar.set(2023, 6, 15);
		Date departureDate2 = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate2 = calendar.getTime();
		
		LocalTime departureTime2 = LocalTime.of(10, 15);
		LocalTime arrivalTime2 = LocalTime.of(16, 35);
		
		TruckLoad load2 = new TruckLoad(12L, departureDate2, arrivalDate2, departureTime2, arrivalTime2, new BigDecimal(2.46), driver2);
        
		LoadItem li2 = new LoadItem();
		li2.setLoad(load2);
        
        
        
        assertTrue(li.equals(li2));
	}
	
	@Test
	void testEqualsTruckLoadDifferent() {
		Calendar calendar = Calendar.getInstance();
		
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
		
		calendar.set(1992, 6, 23);
		Date birthday = calendar.getTime();
		Driver driver = new Driver(4L, "Name", "Surname", birthday, truck);
		
		calendar.set(2023, 6, 15);
		Date departureDate = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate = calendar.getTime();
		
		LocalTime departureTime = LocalTime.of(10, 15);
		LocalTime arrivalTime = LocalTime.of(16, 35);
		
		TruckLoad load = new TruckLoad(12L, departureDate, arrivalDate, departureTime, arrivalTime, new BigDecimal(2.46), driver);
		
        li.setLoad(load);
        
        
        
        Country truckManufacturerCountryOfOrigin2 = new Country(4L, "Sweden");
		Manufacturer truckManufacturer2 = new Manufacturer(3L, "Scania", truckManufacturerCountryOfOrigin2);
		TruckType truckType2 = new TruckType(4L, "Large");
		
		Truck truck2 = new Truck(4L,
								"Citywide LF",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120),
								truckManufacturer2,
								truckType2);
		
		calendar.set(1993, 6, 23);
		Date birthday2 = calendar.getTime();
		Driver driver2 = new Driver(6L, "Name", "Surname", birthday2, truck2);
		
		calendar.set(2023, 6, 17);
		Date departureDate2 = calendar.getTime();
		calendar.set(2023, 6, 18);
		Date arrivalDate2 = calendar.getTime();
		
		LocalTime departureTime2 = LocalTime.of(11, 15);
		LocalTime arrivalTime2 = LocalTime.of(12, 35);
		
		TruckLoad load2 = new TruckLoad(14L, departureDate2, arrivalDate2, departureTime2, arrivalTime2, new BigDecimal(2.46), driver2);
        
		LoadItem li2 = new LoadItem();
		li2.setLoad(load2);
        
        
        
        assertFalse(li.equals(li2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(li.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(li.equals(li));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(li.equals(new Exception()));
	}
}
