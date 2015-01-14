package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LogoutControllerEJB extends ControllerEJB implements LogoutController {

    public LogoutControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }
    
    private void changeState(){
        this.getTicTacToeContext().setTicTacToeStateModel(TicTacToeStateModel.FINAL);
    }

    @Override
    public void logout() {
        assert this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME
                || this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        this.getTicTacToeContext().setPlayer(null);
        this.getTicTacToeContext().setGame(null);
        this.getTicTacToeContext().setSaved(true);
        this.changeState();
    }

    @Override
    public boolean isBye() {
        return this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
    }

    @Override
    public boolean savedGame() {
        return this.getTicTacToeContext().isSavedGame();
    }

}
