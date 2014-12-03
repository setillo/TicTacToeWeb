package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.UserDAO;
import es.art83.ticTacToe.models.entities.UserEntity;

public class UserDAOMemory extends GenericDAOMemory<UserEntity, String> implements UserDAO {

    @Override
    protected String getId(UserEntity entity) {
        return entity.getUser();
    }

}
