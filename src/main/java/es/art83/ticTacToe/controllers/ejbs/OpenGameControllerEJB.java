package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class OpenGameControllerEJB extends ControllerEJB implements OpenGameController {

    public OpenGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void changeSate() {
        this.getTicTacToeContext().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }
 
    
    @Override
    public void openGame(String gameNameSelected) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findGame(this.getTicTacToeContext().getPlayer(), gameNameSelected);
        this.getTicTacToeContext().setGame(game);
        this.getTicTacToeContext().setSaved(true);
        this.changeSate();
    }

}
