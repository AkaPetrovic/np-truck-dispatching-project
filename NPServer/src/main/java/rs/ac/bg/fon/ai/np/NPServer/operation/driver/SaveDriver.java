package rs.ac.bg.fon.ai.np.NPServer.operation.driver;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class SaveDriver extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Driver) param);
    }
}
