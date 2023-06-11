package rs.ac.bg.fon.ai.np.NPServer.operation.driver;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve vozace iz baze podataka postavi u listu.
 * 
 * Sadrzi listu vozaca.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllDrivers extends AbstractGenericOperation{
	/**
	 * Lista vozaca.
	 */
    List<Driver> drivers;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        drivers = repository.getAll((Driver) param);
    }
    
    /**
     * Vraca listu vozaca.
     * @return drivers - Lista vozaca na raspolaganju kompaniji
     */
    public List<Driver> getDrivers() {
        return drivers;
    }
}
