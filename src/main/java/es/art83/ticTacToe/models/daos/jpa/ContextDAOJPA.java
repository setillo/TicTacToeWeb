package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.ContextDAO;
import es.art83.ticTacToe.models.entities.ContextEntity;

public class ContextDAOJPA extends TransactionGenericDAOJPA<ContextEntity, Integer> implements
        ContextDAO {

    public ContextDAOJPA() {
        super(ContextEntity.class);
    }


}
