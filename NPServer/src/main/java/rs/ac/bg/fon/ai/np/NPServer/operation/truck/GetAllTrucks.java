package rs.ac.bg.fon.ai.np.NPServer.operation.truck;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve kamione iz baze podataka postavi u listu.
 * 
 * Sadrzi listu kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllTrucks extends AbstractGenericOperation{
	/**
	 * Lista kamiona u vlasnistvu kompanije.
	 */
    List<Truck> trucks;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        trucks = repository.getAll((Truck) param);
    }

    /**
     * Vraca listu kamiona.
     * @return trucks - Lista kamiona koji su trenutno u vlasnistvu kompanije.
     */
    public List<Truck> getTrucks() {
        return trucks;
    }
}
