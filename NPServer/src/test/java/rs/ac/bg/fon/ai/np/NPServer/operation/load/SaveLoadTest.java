package rs.ac.bg.fon.ai.np.NPServer.operation.load;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;
import rs.ac.bg.fon.ai.np.NPServer.controller.Controller;

public class SaveLoadTest {
	
	@Disabled
	@Test
	void testExecuteOperation() throws Exception {
		Calendar calendar = Calendar.getInstance();
				
		Country country = new Country(1L, "Sweden");
		
		Manufacturer manufacturer = new Manufacturer(2L, "Volvo", country);
		TruckType truckType = new TruckType(2L, "Medium");
		
		Truck truck = new Truck(2L, "FH", 500, new BigDecimal(20130.13), 2019, new BigDecimal(90.25), manufacturer, truckType);
		
		calendar.set(1999, 3, 19);
		Date birthday = calendar.getTime();
		Driver driver = new Driver(4L, "Pavle", "Pajic", birthday, truck);
		
		calendar.set(2023, 6, 15);
		Date departureDate = calendar.getTime();
		calendar.set(2023, 6, 16);
		Date arrivalDate = calendar.getTime();
		
		LocalTime departureTime = LocalTime.of(10, 15);
		LocalTime arrivalTime = LocalTime.of(16, 35);
		
		TruckLoad load = new TruckLoad(null, departureDate, arrivalDate, departureTime, arrivalTime, new BigDecimal(2.46), driver);
		
		LoadItem li1 = new LoadItem(1L, load, "Chair", false, true, new BigDecimal(12.5), new BigDecimal(0.62), LoadItemState.UNCHANGED);
		LoadItem li2 = new LoadItem(2L, load, "Table", false, true, new BigDecimal(21.5), new BigDecimal(1.31), LoadItemState.UNCHANGED);
		
		load.getLoadItems().add(li1);
		load.getLoadItems().add(li2);
		
		Controller.getInstance().addLoad(load);
		
		
		List<TruckLoad> allLoads = Controller.getInstance().getAllLoads(new TruckLoad());
//		for(TruckLoad tl:allLoads) {
//			System.out.println(tl + "\n");
//			System.out.println("Load items for the load:");
//			for(LoadItem li:tl.getLoadItems()) {
//				System.out.print("\t");
//				System.out.println(li);
//			}
//			System.out.println("---------------------------------------------------------------------\n");
//		}
		
		boolean containsTruckLoad = false;
		boolean hasAllLoadItems = false;
		for(TruckLoad tl:allLoads) {
			if(tl.getId().equals(load.getId())) {
				containsTruckLoad = true;
				if(tl.getLoadItems().size() == 2) {
					hasAllLoadItems = true;
				}
				break;
			}
		}
		
		
		
		assertTrue(containsTruckLoad);
		assertTrue(hasAllLoadItems);
	}
}
