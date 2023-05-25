package rs.ac.bg.fon.ai.np.NPServer.operation.country;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllCountries extends AbstractGenericOperation{

    List<Country> countries;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        countries = repository.getAll((Country) param);
    }
    
    public List<Country> getCountries() {
        return countries;
    }
}
