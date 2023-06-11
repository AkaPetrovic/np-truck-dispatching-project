package rs.ac.bg.fon.ai.np.NPServer.operation.load;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sacuva odredjeni tovar u bazi podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class SaveLoad extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        try {
            TruckLoad load = (TruckLoad) param;
            repository.add(load);
            for(LoadItem item:load.getLoadItems()){
                    item.setLoad(load);
                    repository.add(item);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

