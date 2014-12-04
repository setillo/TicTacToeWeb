package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDAOMemory extends GenericDAOMemory<GameEntity, Integer> implements GameDAO {

    @Override
    protected Integer getId(GameEntity entity) {
        return entity.getId();
    }

    @Override
    public List<String> findPlayerNamesGames(PlayerEntity playerEntity) {
        List<String> namesGames = new ArrayList<>();
        List<GameEntity> games = this.findAll();
        for (GameEntity gameEntity : games) {
            if (gameEntity.getPlayerEntity().equals(playerEntity))
                namesGames.add(gameEntity.getName());
        }
        return namesGames;
    }

}
