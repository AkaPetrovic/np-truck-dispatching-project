package rs.ac.bg.fon.ai.np.NPServer.operation.manufacturer;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllManufacturers extends AbstractGenericOperation{

    List<Manufacturer> manufacturers;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        manufacturers = repository.getAll((Manufacturer) param);
    }
    
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
}
