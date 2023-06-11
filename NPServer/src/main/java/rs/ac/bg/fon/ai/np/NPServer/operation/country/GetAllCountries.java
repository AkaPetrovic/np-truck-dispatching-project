package rs.ac.bg.fon.ai.np.NPServer.operation.country;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve drzave, iz kojih dolaze proizvodjaci kamiona, iz baze podataka postavi u listu.
 * 
 * Sadrzi listu drzava.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllCountries extends AbstractGenericOperation{
	/**
	 * Lista drzava.
	 */
    List<Country> countries;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        countries = repository.getAll((Country) param);
    }
    
    /**
     * Vraca listu drzava.
     * @return countries - Lista drzava iz kojih dolaze proizvodjaci kamiona.
     */
    public List<Country> getCountries() {
        return countries;
    }
}
