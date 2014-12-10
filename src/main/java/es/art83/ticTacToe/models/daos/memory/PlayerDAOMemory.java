package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDAOMemory extends GenericDAOMemory<PlayerEntity, String> implements PlayerDAO {

    @Override
    protected String getId(PlayerEntity entity) {
        return entity.getUser();
    }

    @Override
    public void create(PlayerEntity entity) {
        PlayerEntity player = new PlayerEntity();
        player.setUser(entity.getUser());
        player.setPassword(entity.getPassword());
        this.getBd().put(player.getUser(), player);
    }

    @Override
    public void update(PlayerEntity entity) {
        PlayerEntity player = this.read(entity.getUser());
        assert player != null;
        player.setPassword(entity.getPassword());
    }

}
