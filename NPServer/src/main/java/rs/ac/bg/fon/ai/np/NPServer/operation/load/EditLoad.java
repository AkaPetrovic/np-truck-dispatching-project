package rs.ac.bg.fon.ai.np.NPServer.operation.load;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class EditLoad extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        try {
            TruckLoad load = (TruckLoad) param;
            repository.edit(load);

            for(LoadItem item:load.getLoadItems()){
                System.out.println(item.getState());
            }
            
            for(LoadItem item:load.getLoadItems()){
                if(item.getState().equals(LoadItemState.DELETE)){
                    repository.delete(item);
                }
            }
            for(LoadItem item:load.getLoadItems()){
                if(item.getState().equals(LoadItemState.INSERT)){
                    repository.add(item);
                }
            }
            for(LoadItem item:load.getLoadItems()){
                if(item.getState().equals(LoadItemState.EDITED)){
                    repository.edit(item);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
