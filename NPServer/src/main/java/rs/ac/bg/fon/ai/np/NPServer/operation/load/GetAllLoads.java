package rs.ac.bg.fon.ai.np.NPServer.operation.load;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllLoads extends AbstractGenericOperation{

    List<TruckLoad> loads;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        loads = repository.getAll((TruckLoad) param);
        List<LoadItem> items = repository.getAll(new LoadItem());
        for(TruckLoad load:loads){
            for(LoadItem item:items){
                if(load.getId().equals(item.getLoad().getId())){
                    item.setLoad(load);
                    load.getLoadItems().add(item);
                }
            }
        }
    }
    
    public List<TruckLoad> getLoads() {
        return loads;
    }
}
