package es.art83.ticTacToe.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.ticTacToe.models.daos.ContextDAO;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.daos.PlayerDAO;

public class DAOJPAFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private EntityManager em;

    public DAOJPAFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public EntityManager getEm() {
        if (!em.isOpen()) {
            this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
                    .createEntityManager();
        }
        return em;
    }

    @Override
    public PlayerDAO getPlayerDAO() {
        return new PlayerDAOJPA();
    }

    @Override
    public GameDAO getGameDAO() {
        return new GameDAOJPA();
    }

    @Override
    public ContextDAO getContextDAO() {
        return new ContextDAOJPA();
    }

}
