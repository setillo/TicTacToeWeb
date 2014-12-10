package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.daos.PlayerDAO;

public class DAOMemoryFactory extends DAOFactory {

    private PlayerDAO playerDAO = new PlayerDAOMemory();

    private GameDAO gameDAO = new GameDAOMemory();

    public DAOMemoryFactory() {
    }

    @Override
    public PlayerDAO getPlayerDAO() {
        return this.playerDAO;
    }

    @Override
    public GameDAO getGameDAO() {
        return this.gameDAO;
    }

}
