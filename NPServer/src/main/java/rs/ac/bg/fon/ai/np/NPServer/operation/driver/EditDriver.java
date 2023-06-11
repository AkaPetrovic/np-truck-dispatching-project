package rs.ac.bg.fon.ai.np.NPServer.operation.driver;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

/**
 * Predstavlja specificnu operaciju koja ima za cilj da sacuva promene napravljene na odredjenom vozacu u bazi podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class EditDriver extends AbstractGenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Driver) param);
    }
}
