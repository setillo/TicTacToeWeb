package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LogoutControllerEJB extends ControllerEJB implements LogoutController {

    public LogoutControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void logout() {
        assert this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME
                || this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME;
        
        //Falta controlar salvar la partida!!!
        
        this.getTicTacToeStatesManager().setPlayer(null);
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.FINAL);
    }

}
