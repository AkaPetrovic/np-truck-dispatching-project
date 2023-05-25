package rs.ac.bg.fon.ai.np.NPServer.operation.trucktype;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllTruckTypes extends AbstractGenericOperation{

    List<TruckType> truckTypes;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        truckTypes = repository.getAll((TruckType) param);
    }
    
    public List<TruckType> getTruckTypes() {
        return truckTypes;
    }
}
