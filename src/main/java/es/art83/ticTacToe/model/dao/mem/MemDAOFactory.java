package es.art83.ticTacToe.model.dao.mem;

import es.art83.ticTacToe.model.dao.DAOFactory;
import es.art83.ticTacToe.model.dao.UserDAO;

public class MemDAOFactory extends DAOFactory {

    private UserDAO memUserDAO = new MemUserDAO();

    public MemDAOFactory() {
    }

    @Override
    public UserDAO getUserDAO() {
        return memUserDAO;
    }

}
