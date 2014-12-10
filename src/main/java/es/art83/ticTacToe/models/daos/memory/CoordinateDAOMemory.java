package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.CoordinateDAO;
import es.art83.ticTacToe.models.entities.CoordinateEntity;

public class CoordinateDAOMemory extends GenericDAOMemory<CoordinateEntity, Integer> implements CoordinateDAO{

    @Override
    protected Integer getId(CoordinateEntity entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected CoordinateEntity clone(CoordinateEntity entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
