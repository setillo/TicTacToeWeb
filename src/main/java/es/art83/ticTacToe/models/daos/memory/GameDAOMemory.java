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
    protected GameEntity clone(GameEntity entity) {
        GameEntity game = new GameEntity(entity.getName(), entity.getPlayerEntity());
        game.setId(IdGenerator.getInstance().generate(GameEntity.class.getName()));
        game.setBoardEntity(((BoardDAOMemory) DAOMemoryFactory.getFactory().getBoardDAO())
                .clone(entity.getBoardEntity()));
        game.setTurnEntity(((TurnDAOMemory) DAOMemoryFactory.getFactory().getTurnDAO())
                .clone(entity.getTurnEntity()));
        return game;
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
