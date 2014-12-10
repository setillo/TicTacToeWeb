package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.BoardEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.entities.TurnEntity;

public class GameDAOMemory extends GenericDAOMemory<GameEntity, Integer> implements GameDAO {

    @Override
    protected Integer getId(GameEntity entity) {
        return entity.getId();
    }

    @Override
    public void create(GameEntity entity) {
        GameEntity game = new GameEntity(entity.getName(), entity.getPlayerEntity());
        game.setId(IdGenerator.getInstance().generate(GameEntity.class.getName()));
        entity.setId(game.getId());

        BoardEntity board = new BoardEntity();
        board.setId(IdGenerator.getInstance().generate(BoardEntity.class.getName()));
        entity.getBoardEntity().setId(board.getId());
        board.setFichas(entity.getBoardEntity().getFichas());
        game.setBoardEntity(board);

        TurnEntity turn = new TurnEntity();
        turn.setId(IdGenerator.getInstance().generate(TurnEntity.class.getName()));
        entity.getTurnEntity().setId(turn.getId());
        turn.setColor(entity.getTurnEntity().getColor());
        game.setTurnEntity(turn);

        this.getBd().put(game.getId(), game);
    }

    @Override
    public void update(GameEntity entity) {
        GameEntity game = this.read(entity.getId());
        assert game != null;
        BoardEntity board = game.getBoardEntity();
        board.setFichas(entity.getBoardEntity().getFichas());

        TurnEntity turn = game.getTurnEntity();
        turn.setColor(entity.getTurnEntity().getColor());
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

    @Override
    public GameEntity findGame(PlayerEntity player, String nameGame) {
        GameEntity gameBD = null;
        List<GameEntity> games = this.findAll();
        for (GameEntity game : games) {
            if (game.getPlayerEntity().equals(player) && game.getName().equals(nameGame)) {
                gameBD = game;
                break;
            }
        }
        return gameBD;
    }
}
