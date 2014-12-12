package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDAOJPA extends TransactionGenericDAOJPA<PlayerEntity, String> implements
        PlayerDAO {

    public PlayerDAOJPA() {
        super(PlayerEntity.class);
    }

}
