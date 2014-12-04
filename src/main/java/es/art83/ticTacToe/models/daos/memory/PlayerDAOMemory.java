package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDAOMemory extends GenericDAOMemory<PlayerEntity, String> implements PlayerDAO {

    @Override
    protected String getId(PlayerEntity entity) {
        return entity.getUser();
    }

}
