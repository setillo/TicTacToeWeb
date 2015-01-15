package es.art83.ticTacToe.models.daos;

import es.art83.ticTacToe.models.daos.jpa.DAOJPAFactory;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new DAOJPAFactory();
        }
        return factory;
    }

    public abstract PlayerDAO getPlayerDAO();
    
    public abstract GameDAO getGameDAO();
    
    public abstract ContextDAO getContextDAO();
    
}
