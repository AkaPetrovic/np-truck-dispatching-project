package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class SaveTruck extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Truck) param);
    }
}
