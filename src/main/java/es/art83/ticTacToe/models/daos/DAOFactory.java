package es.art83.ticTacToe.models.daos;

import es.art83.ticTacToe.models.daos.memory.DAOMemoryFactory;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new DAOMemoryFactory();
        }
        return factory;
    }

    public abstract PlayerDAO getPlayerDAO();
    
    public abstract GameDAO getGameDAO();
    
    public abstract BoardDAO getBoardDAO();
    
    public abstract TurnDAO getTurnDAO();

}
