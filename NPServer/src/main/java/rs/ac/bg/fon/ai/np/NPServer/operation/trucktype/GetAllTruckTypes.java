package rs.ac.bg.fon.ai.np.NPServer.operation.trucktype;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve kamione iz baze podataka postavi u listu.
 * 
 * Sadrzi listu tipova kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllTruckTypes extends AbstractGenericOperation{
	/**
	 * Lista tipova kamiona.
	 */
    List<TruckType> truckTypes;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        truckTypes = repository.getAll((TruckType) param);
    }
    
    /**
     * Vraca listu tipova kamiona.
     * @return truckTypes - Lista tipova kamiona.
     */
    public List<TruckType> getTruckTypes() {
        return truckTypes;
    }
}
