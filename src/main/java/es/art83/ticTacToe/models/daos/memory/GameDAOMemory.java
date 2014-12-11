package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDAOMemory extends GenericDAOMemory<GameEntity, Integer> implements GameDAO {

    @Override
    public void create(GameEntity entity) {
        assert !getEntityList().contains(entity);
        getEntityList().add(entity.clone());
    }

    @Override
    public GameEntity read(Integer id) {
        return null;
    }

    @Override
    public void update(GameEntity entity) {
        GameEntity gameBD = this.getEntityList().get(this.getEntityList().indexOf(entity));
        gameBD.update(entity);
    }

    @Override
    public void delete(GameEntity entity) {
        getEntityList().remove(entity);
    }

    @Override
    public void deleteByID(Integer id) {
    }


    @Override
    public List<String> findPlayerGameNames(PlayerEntity player) {
        List<String> gameNames = new ArrayList<>();
        for (GameEntity game : getEntityList()) {
            if (game.getPlayer().equals(player))
                gameNames.add(game.getName());
        }
        return gameNames;
    }

    @Override
    public GameEntity findGame(PlayerEntity player, String gameName) {
        GameEntity gameBD = null;
        int index = getEntityList().indexOf(new GameEntity(gameName, player));
        if (index != -1) {
            gameBD = getEntityList().get(index).clone();
        }
        return gameBD;
    }

}
