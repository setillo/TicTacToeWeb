package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDAOMemory extends GenericDAOMemory<PlayerEntity, String> implements PlayerDAO {

    @Override
    public void create(PlayerEntity entity) {
        assert !getEntityList().contains(entity);
        getEntityList().add(entity.clone());
    }

    @Override
    public PlayerEntity read(String id) {
        PlayerEntity playerBD = null;
        int index = getEntityList().indexOf(new PlayerEntity(id, null));
        if (index != -1) {
            playerBD = getEntityList().get(index).clone();
        }
        return playerBD;
    }

    @Override
    public void update(PlayerEntity entity) {
        PlayerEntity playerBD = this.getEntityList().get(this.getEntityList().indexOf(entity));
        playerBD.update(entity);
    }

    @Override
    public void deleteByID(String id) {
        this.delete(new PlayerEntity(id, null));
    }

}
