package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class OpenGameControllerEJB extends ControllerEJB implements OpenGameController {

    public OpenGameControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void openGame(String gameNameSelected) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findGame(this.getTicTacToeStatesManager().getPlayer(), gameNameSelected);
        this.getTicTacToeStatesManager().setGame(game);
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
        this.getTicTacToeStatesManager().setSaved(true);
    }

}
