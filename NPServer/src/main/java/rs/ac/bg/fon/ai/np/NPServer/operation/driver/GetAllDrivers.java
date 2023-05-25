package rs.ac.bg.fon.ai.np.NPServer.operation.driver;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllDrivers extends AbstractGenericOperation{

    List<Driver> drivers;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        drivers = repository.getAll((Driver) param);
    }
    
    public List<Driver> getDrivers() {
        return drivers;
    }
}
