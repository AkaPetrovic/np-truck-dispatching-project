package rs.ac.bg.fon.ai.np.NPServer.operation.truckmaintenance;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllTruckMaintenances extends AbstractGenericOperation{

    List<TruckMaintenance> truckMaintenances;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        truckMaintenances = repository.getAll((TruckMaintenance) param);
    }
    
    public List<TruckMaintenance> getTruckMaintenances() {
        return truckMaintenances;
    }
}
