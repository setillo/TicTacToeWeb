package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class OpenGameControllerEJB extends ControllerEJB implements OpenGameController {

    public OpenGameControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void changeSate() {
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }
 
    
    @Override
    public void openGame(String gameNameSelected) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findGame(this.getTicTacToeStatesManager().getPlayer(), gameNameSelected);
        this.getTicTacToeStatesManager().setGame(game);
        this.getTicTacToeStatesManager().setSaved(true);
        this.changeSate();
    }

}
