package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.BoardDAO;
import es.art83.ticTacToe.models.entities.BoardEntity;

public class BoardDAOMemory extends GenericDAOMemory<BoardEntity, Integer> implements BoardDAO {

    @Override
    protected Integer getId(BoardEntity entity) {
        return entity.getId();
    }

    @Override
    protected BoardEntity clone(BoardEntity entity) {
        BoardEntity board = new BoardEntity();
        board.setId(IdGenerator.getInstance().generate(BoardEntity.class.getName()));
        board.setFichas(entity.getFichas());
        return board;
    }

}
