package es.art83.ticTacToe.models.daos;

import java.util.List;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public interface GameDAO extends GenericDAO<GameEntity, Integer> {
    List<String> findPlayerNamesGames(PlayerEntity playerEntity);

    GameEntity findGame(PlayerEntity player, String nameGame);
}
