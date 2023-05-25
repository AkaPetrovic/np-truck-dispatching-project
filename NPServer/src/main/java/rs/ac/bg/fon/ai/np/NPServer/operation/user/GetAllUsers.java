package rs.ac.bg.fon.ai.np.NPServer.operation.user;

import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.User;
import rs.ac.bg.fon.ai.np.NPServer.operation.AbstractGenericOperation;

public class GetAllUsers extends AbstractGenericOperation{

    List<User> users;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = repository.getAll((User) param);
    }
    
    public List<User> getUsers() {
        return users;
    }
}
