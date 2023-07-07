package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sacuva izmene napravljenje nad podacima o odredjenom kamionu u bazi podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class EditTruck extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Truck) param);
    }
}
