package rs.ac.bg.fon.ai.np.NPServer.operation.user;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.User;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sve korisnike aplikacije iz baze podataka postavi u listu.
 * 
 * Sadrzi listu korisnika.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class GetAllUsers extends AbstractGenericOperation{
	/**
	 * Lista korisnika aplikacije.
	 */
    List<User> users;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = repository.getAll((User) param);
    }
    
    /**
     * Vraca listu korisnika.
     * @return users - Lista korisnika aplikacije.
     */
    public List<User> getUsers() {
        return users;
    }
}
