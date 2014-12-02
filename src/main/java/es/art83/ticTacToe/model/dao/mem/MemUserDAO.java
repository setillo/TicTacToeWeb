package es.art83.ticTacToe.model.dao.mem;

import es.art83.ticTacToe.model.dao.UserDAO;
import es.art83.ticTacToe.model.entities.User;

public class MemUserDAO extends MemGenericDAO<User, String> implements UserDAO {

    @Override
    protected String getId(User entity) {
        return entity.getUser();
    }

}
