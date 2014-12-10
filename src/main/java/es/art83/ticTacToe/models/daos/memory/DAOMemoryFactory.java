package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.BoardDAO;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.daos.TurnDAO;

public class DAOMemoryFactory extends DAOFactory {

    private PlayerDAO playerDAO = new PlayerDAOMemory();

    private GameDAO gameDAO = new GameDAOMemory();
    
    private BoardDAO boardDAO = new BoardDAOMemory();
    
    private TurnDAO turnDAO = new TurnDAOMemory();

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

    @Override
    public BoardDAO getBoardDAO() {
        return this.boardDAO;
    }

    @Override
    public TurnDAO getTurnDAO() {
        return this.turnDAO;
    }

}
