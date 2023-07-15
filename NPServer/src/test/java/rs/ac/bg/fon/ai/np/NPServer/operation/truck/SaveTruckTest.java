package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPServer.controller.Controller;

public class SaveTruckTest {
	
	@Disabled
	@Test
	void testExecuteOperation() throws Exception {
		Country truckManufacturerCountryOfOrigin = new Country(1L, "Sweden");
		Manufacturer truckManufacturer = new Manufacturer(1L, "Scania", truckManufacturerCountryOfOrigin);
		TruckType truckType = new TruckType(3L, "Large");
		
		Truck truck = new Truck(null,
								"Test truck",
								450,
								new BigDecimal(512625.50),
								2005,
								new BigDecimal(120.5),
								truckManufacturer,
								truckType);
		Controller.getInstance().addTruck(truck);
		
		
		List<Truck> allTrucks = Controller.getInstance().getAllTrucks(new Truck());
		
		boolean containsTruck = false;
		for(Truck t:allTrucks) {
			if(t.getId().equals(truck.getId())) {
				containsTruck = true;
				break;
			}
		}
		
		
		
		assertTrue(containsTruck);
	}
}
