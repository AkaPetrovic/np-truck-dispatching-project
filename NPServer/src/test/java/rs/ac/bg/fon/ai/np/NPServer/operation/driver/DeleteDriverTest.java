package rs.ac.bg.fon.ai.np.NPServer.operation.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPServer.controller.Controller;

public class DeleteDriverTest {

	@Test
	void testExecuteOperation() throws Exception {
		Calendar calendar = Calendar.getInstance();
		
		
		
		Country country = new Country(1L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(2L, "Volvo", country);
		TruckType truckType = new TruckType(2L, "Medium");
		
		Truck truck = new Truck(2L, "FH", 500, new BigDecimal(20130.13), 2019, new BigDecimal(90.25), manufacturer, truckType);
		
		calendar.set(1990, 3, 23);
        Date birthday = calendar.getTime();
		Driver driver = new Driver(3L, "Name", "Surname", birthday, truck);
		
		Controller.getInstance().addDriver(driver);
		
		
		
		List<Driver> allDrivers = Controller.getInstance().getAllDrivers(new Driver());
		
		boolean containsDriver = false;
		for(Driver d:allDrivers) {
			if(d.getId().equals(driver.getId())) {
				containsDriver = true;
				break;
			}
		}
		
		assertTrue(containsDriver);
		
		Controller.getInstance().deleteDriver(driver);
		
		allDrivers = Controller.getInstance().getAllDrivers(new Driver());
		
		containsDriver = false;
		for(Driver d:allDrivers) {
			if(d.getId().equals(driver.getId())) {
				containsDriver = true;
				break;
			}
		}
		
		assertFalse(containsDriver);
	}

}
