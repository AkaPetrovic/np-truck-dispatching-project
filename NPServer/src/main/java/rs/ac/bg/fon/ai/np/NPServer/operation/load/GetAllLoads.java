package rs.ac.bg.fon.ai.np.NPServer.operation.load;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve tovare iz baze podataka postavi u listu.
 * 
 * Sadrzi listu tovara.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllLoads extends AbstractGenericOperation{
	/**
	 * Lista tovara.
	 */
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
    
    /**
     * Vraca listu tovara.
     * @return loads - Lista tovara.
     */
    public List<TruckLoad> getLoads() {
        return loads;
    }
}
