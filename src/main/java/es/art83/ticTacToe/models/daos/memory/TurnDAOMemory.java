package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.TurnDAO;
import es.art83.ticTacToe.models.entities.TurnEntity;

public class TurnDAOMemory extends GenericDAOMemory<TurnEntity, Integer> implements TurnDAO {

    @Override
    protected Integer getId(TurnEntity entity) {
        return entity.getId();
    }

    @Override
    protected TurnEntity clone(TurnEntity entity) {
        TurnEntity turn = new TurnEntity();
        turn.setId(IdGenerator.getInstance().generate(TurnEntity.class.getName()));
        turn.setColor(entity.getColor());
        return turn;
    }

 
}
