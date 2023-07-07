package rs.ac.bg.fon.ai.np.NPServer.operation.truckmaintenance;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve servise kamiona iz baze podataka postavi u listu.
 * 
 * Sadrzi listu servisa kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllTruckMaintenances extends AbstractGenericOperation{
	/**
	 * Lista servise kamiona.
	 */
    List<TruckMaintenance> truckMaintenances;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        truckMaintenances = repository.getAll((TruckMaintenance) param);
    }
    
    /**
     * Vraca listu servisa kamiona.
     * @return truckMaintenances - Lista servisa kamiona.
     */
    public List<TruckMaintenance> getTruckMaintenances() {
        return truckMaintenances;
    }
}
