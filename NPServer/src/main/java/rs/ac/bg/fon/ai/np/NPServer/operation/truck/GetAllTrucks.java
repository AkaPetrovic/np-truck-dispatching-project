package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllTrucks extends AbstractGenericOperation{

    List<Truck> trucks;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        trucks = repository.getAll((Truck) param);
    }

    public List<Truck> getTrucks() {
        return trucks;
    }
}
