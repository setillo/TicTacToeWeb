package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.PlayerDAO;

public class DAOMemoryFactory extends DAOFactory {

    private PlayerDAO memUserDAO = new UserDAOMemory();

    public DAOMemoryFactory() {
    }

    @Override
    public PlayerDAO getUserDAO() {
        return memUserDAO;
    }

}
