package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.DAOFactory;

public class DAOMemoryFactory extends DAOFactory {

    private PlayerDAOMemory playerDAO = new PlayerDAOMemory();

    private GameDAOMemory gameDAO = new GameDAOMemory();

    public DAOMemoryFactory() {
    }

    @Override
    public PlayerDAOMemory getPlayerDAO() {
        return this.playerDAO;
    }

    @Override
    public GameDAOMemory getGameDAO() {
        return this.gameDAO;
    }

}
