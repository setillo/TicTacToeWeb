package es.art83.ticTacToe.model.dao;

import es.art83.ticTacToe.model.dao.mem.MemDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new MemDAOFactory();
        }
        return factory;
    }

    public abstract UserDAO getUserDAO();

}
