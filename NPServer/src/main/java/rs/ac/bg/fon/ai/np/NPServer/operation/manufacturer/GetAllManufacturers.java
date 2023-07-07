package rs.ac.bg.fon.ai.np.NPServer.operation.manufacturer;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve proizvodjace kamiona iz baze podataka postavi u listu.
 * 
 * Sadrzi listu servisa kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllManufacturers extends AbstractGenericOperation{
	/**
	 * Lista proizvodjaca kamiona.
	 */
    List<Manufacturer> manufacturers;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        manufacturers = repository.getAll((Manufacturer) param);
    }
    
    /**
     * Vraca listu proizvodjaca kamiona.
     * @return manufacturers - Lista proizvodjaca kamiona.
     */
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
}
