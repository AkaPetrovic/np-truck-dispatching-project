package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPServer.controller.Controller;

public class EditTruckTest {

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
		
		Truck truckForEdit = null;
		for(Truck t:allTrucks) {
			if(t.equals(truck)) {
				truckForEdit = t;
				break;
			}
		}
		
		if(truckForEdit != null) {
			truckForEdit.setModel("Test truck edited");
			truckForEdit.setPower(500);
			truckForEdit.setKmTravelled(new BigDecimal(612625.50));
			truckForEdit.setYear(2006);
			truckForEdit.setCarryingCapacity(new BigDecimal(122.5));
			Controller.getInstance().editTruck(truckForEdit);
			
			allTrucks = Controller.getInstance().getAllTrucks(new Truck());
			
			boolean containsEditedTruck = false;
			for(Truck t:allTrucks) {
				if(t.equals(truckForEdit)) {
					containsEditedTruck = true;
					break;
				}
			}
			assertTrue(containsEditedTruck);
		}
	}

}
