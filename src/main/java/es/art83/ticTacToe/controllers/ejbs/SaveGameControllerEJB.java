package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;

public class SaveGameControllerEJB extends ControllerEJB implements SaveGameController {

    public SaveGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void saveGame(String gameName) {
        this.getTicTacToeContext().getGame().setName(gameName);
        DAOFactory.getFactory().getGameDAO().create(this.getTicTacToeContext().getGame());
        this.getTicTacToeContext().setSaved(true);
    }

    @Override
    public void overWriteGame(String gameName) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findGame(this.getTicTacToeContext().getPlayer(), gameName);
        DAOFactory.getFactory().getGameDAO().delete(game);
        this.saveGame(gameName);
    }

    @Override
    public void saveGame() {
        DAOFactory.getFactory().getGameDAO().update(this.getTicTacToeContext().getGame());
        this.getTicTacToeContext().setSaved(true);
    }

}
