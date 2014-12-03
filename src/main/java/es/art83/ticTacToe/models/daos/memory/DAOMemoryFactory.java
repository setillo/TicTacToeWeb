package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.UserDAO;

public class DAOMemoryFactory extends DAOFactory {

    private UserDAO memUserDAO = new UserDAOMemory();

    public DAOMemoryFactory() {
    }

    @Override
    public UserDAO getUserDAO() {
        return memUserDAO;
    }

}
