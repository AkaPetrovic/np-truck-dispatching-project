package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;

public class TruckLoadTest {

	private TruckLoad tl;
	
	@BeforeEach
	void setUp() throws Exception {
		tl = new TruckLoad();
	}

	@AfterEach
	void tearDown() throws Exception {
		tl = null;
	}

	@Test
	void testSetId() {
		tl.setId(5L);
		assertEquals(5L, tl.getId());
	}
	
	@Test
	void testSetStartDate() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2023, 6, 15);
        Date startDate = calendar.getTime();
		
		tl.setStartDate(startDate);
		assertEquals(startDate, tl.getStartDate());
	}
	
	@Test
	void testSetEndDate() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2023, 6, 16);
        Date endDate = calendar.getTime();
		
		tl.setEndDate(endDate);
		assertEquals(endDate, tl.getEndDate());
	}
	
	@Test
	void testSetStartTime() {
		LocalTime startTime = LocalTime.of(10, 30);
		
		tl.setStartTime(startTime);
		
		assertEquals(startTime, tl.getStartTime());
	}
	
	@Test
	void testSetEndTime() {
		LocalTime endTime = LocalTime.of(5, 30);
		
		tl.setEndTime(endTime);
		
		assertEquals(endTime, tl.getEndTime());
	}
	
	@Test
	void testSetIncomePerKilometerTime() {
		tl.setIncomePerKilometer(new BigDecimal(2.54));
		
		assertEquals(new BigDecimal(2.54), tl.getIncomePerKilometer());
	}
	
	@Test
	void testSetDriver() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		calendar.set(1990, 3, 23);
        Date birthday = calendar.getTime();
		Driver driver = new Driver(3L, "Name", "Surname", birthday, truck);
		
		tl.setDriver(driver);
		
		
		
		assertEquals(driver, tl.getDriver());
	}
	
	@Test
	void testSetLoadItems() {
		List<LoadItem> loadItems = new ArrayList<>();
		LoadItem li1 = new LoadItem(1L, tl, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li2 = new LoadItem(2L, tl, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		
		loadItems.add(li1);
		loadItems.add(li2);
		
		tl.getLoadItems().add(li1);
		tl.getLoadItems().add(li2);
		
		assertEquals(loadItems, tl.getLoadItems());
	}
	
	@Test
	void testToString() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		tl.setId(5L);
		
		calendar.set(2023, 6, 15);
        Date startDate = calendar.getTime();
        tl.setStartDate(startDate);
        
        calendar.set(2023, 6, 16);
        Date endDate = calendar.getTime();
        tl.setEndDate(endDate);
        
        LocalTime startTime = LocalTime.of(10, 30);
		tl.setStartTime(startTime);
		
		LocalTime endTime = LocalTime.of(5, 30);
		tl.setEndTime(endTime);
		
		
		
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		calendar.set(1990, 3, 23);
        Date birthday = calendar.getTime();
		Driver driver = new Driver(3L, "Name", "Surname", birthday, truck);
		
		tl.setDriver(driver);
		
		
		
		tl.setIncomePerKilometer(new BigDecimal(2.54));
		
		LoadItem li1 = new LoadItem(1L, tl, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li2 = new LoadItem(2L, tl, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		tl.getLoadItems().add(li1);
		tl.getLoadItems().add(li2);
		
		assertEquals("5 | Departure date: 15.07.2023. | Arrival date: 16.07.2023. | Departure time: 10:30 | Arrival time: 05:30 | Income per kilometer: 2.54000000000000003552713678800500929355621337890625 // Driver: Name Surname", tl.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, 2.54, 1, 2.54, true",
		"1, 2.54, 1, 3.54, false",
		"1, 2.54, 2, 2.54, false"
	})
	void testEquals(Long id1, BigDecimal incomePerKilometer1, Long id2, BigDecimal incomePerKilometer2, boolean same) {
		tl.setId(id1);
		tl.setIncomePerKilometer(incomePerKilometer1);
		
		TruckLoad tl2 = new TruckLoad();
		
		tl2.setId(id2);
		tl2.setIncomePerKilometer(incomePerKilometer2);
		
		assertEquals(same, tl.equals(tl2));
	}
	
	@Test
	void testEqualsStartDateSame() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 6, 15);
        Date startDate = calendar.getTime();
        tl.setStartDate(startDate);
        
        TruckLoad tl2 = new TruckLoad();

        calendar.set(2023, 6, 15);
        Date startDate2 = calendar.getTime();
        tl2.setStartDate(startDate2);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsStartDateDifferent() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 6, 15);
        Date startDate = calendar.getTime();
        tl.setStartDate(startDate);
        
        TruckLoad tl2 = new TruckLoad();

        calendar.set(2023, 6, 16);
        Date startDate2 = calendar.getTime();
        tl2.setStartDate(startDate2);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsEndDateSame() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 7, 15);
        Date endDate = calendar.getTime();
        tl.setStartDate(endDate);
        
        TruckLoad tl2 = new TruckLoad();

        calendar.set(2023, 7, 15);
        Date endDate2 = calendar.getTime();
        tl2.setStartDate(endDate2);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsEndDateDifferent() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		calendar.set(2023, 7, 15);
        Date endDate = calendar.getTime();
        tl.setEndDate(endDate);
        
        TruckLoad tl2 = new TruckLoad();

        calendar.set(2023, 7, 16);
        Date endDate2 = calendar.getTime();
        tl2.setEndDate(endDate2);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsStartTimeSame() {
		LocalTime startTime = LocalTime.of(10, 30);
		tl.setStartTime(startTime);
        
        TruckLoad tl2 = new TruckLoad();

        LocalTime startTime2 = LocalTime.of(10, 30);
		tl2.setStartTime(startTime2);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsStartTimeDifferent() {
		LocalTime startTime = LocalTime.of(10, 30);
		tl.setStartTime(startTime);
        
        TruckLoad tl2 = new TruckLoad();

        LocalTime startTime2 = LocalTime.of(11, 30);
		tl2.setStartTime(startTime2);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsEndTimeSame() {
		LocalTime endTime = LocalTime.of(10, 30);
		tl.setEndTime(endTime);
        
        TruckLoad tl2 = new TruckLoad();

        LocalTime endTime2 = LocalTime.of(10, 30);
		tl2.setEndTime(endTime2);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsEndTimeDifferent() {
		LocalTime endTime = LocalTime.of(10, 30);
		tl.setEndTime(endTime);
        
        TruckLoad tl2 = new TruckLoad();

        LocalTime endTime2 = LocalTime.of(11, 30);
		tl2.setEndTime(endTime2);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsDriverSame() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		calendar.set(1990, 3, 23);
        Date birthday = calendar.getTime();
		Driver driver = new Driver(3L, "Name", "Surname", birthday, truck);
		
		tl.setDriver(driver);
        
		
		
        TruckLoad tl2 = new TruckLoad();

        Country country2 = new Country(4L, "Sweden");
		
		Manufacturer manufacturer2 = new Manufacturer(4L, "Scania", country2);
		TruckType truckType2 = new TruckType(3L, "Medium");
		
		Truck truck2 = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer2, truckType2);
		
		calendar.set(1990, 3, 23);
        Date birthday2 = calendar.getTime();
		Driver driver2 = new Driver(3L, "Name", "Surname", birthday2, truck2);
		
		tl2.setDriver(driver2);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsDriverDifferent() {
		Calendar calendar = Calendar.getInstance();
		
		
		
		Country country = new Country(4L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(4L, "Scania", country);
		TruckType truckType = new TruckType(3L, "Medium");
		
		Truck truck = new Truck(2L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer, truckType);
		
		calendar.set(1990, 3, 23);
        Date birthday = calendar.getTime();
		Driver driver = new Driver(3L, "Name", "Surname", birthday, truck);
		
		tl.setDriver(driver);
        
		
		
        TruckLoad tl2 = new TruckLoad();

        Country country2 = new Country(5L, "Sweden");
		
		Manufacturer manufacturer2 = new Manufacturer(6L, "Scania", country);
		TruckType truckType2 = new TruckType(1L, "Medium");
		
		Truck truck2 = new Truck(4L, "560R", 500, new BigDecimal(132503.52), 2004, new BigDecimal(67.45), manufacturer2, truckType2);
		
		calendar.set(1991, 3, 23);
        Date birthday2 = calendar.getTime();
		Driver driver2 = new Driver(4L, "Name", "Surname", birthday2, truck2);
		
		tl.setDriver(driver2);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsLoadItemsSame() {
		LoadItem li11 = new LoadItem(1L, tl, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li21 = new LoadItem(2L, tl, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		tl.getLoadItems().add(li11);
		tl.getLoadItems().add(li21);
        
		
		
        TruckLoad tl2 = new TruckLoad();

        LoadItem li12 = new LoadItem(1L, tl, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li22 = new LoadItem(2L, tl, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		tl2.getLoadItems().add(li12);
		tl2.getLoadItems().add(li22);
        
        
        
        assertTrue(tl.equals(tl2));
	}
	
	@Test
	void testEqualsLoadItemsDifferent() {
		LoadItem li11 = new LoadItem(1L, tl, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li21 = new LoadItem(2L, tl, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		tl.getLoadItems().add(li11);
		tl.getLoadItems().add(li21);
        
		
		
        TruckLoad tl2 = new TruckLoad();

        LoadItem li12 = new LoadItem(1L, tl, "Chairs", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li22 = new LoadItem(2L, tl, "Tables", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		tl2.getLoadItems().add(li12);
		tl2.getLoadItems().add(li22);
        
        
        
        assertFalse(tl.equals(tl2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(tl.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(tl.equals(tl));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(tl.equals(new Exception()));
	}

}
