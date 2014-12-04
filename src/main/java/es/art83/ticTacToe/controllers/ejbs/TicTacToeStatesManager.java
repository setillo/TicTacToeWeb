package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class TicTacToeStatesManager {
    private TicTacToeStateModel ticTacToeStateModel;
    
    public TicTacToeStateModel getTicTacToeStateModel() {
        return this.ticTacToeStateModel;
    }

    public TicTacToeStatesManager() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
    }

    public void login() {
        assert this.ticTacToeStateModel == TicTacToeStateModel.INITIAL
                || this.ticTacToeStateModel == TicTacToeStateModel.FINAL;
        this.ticTacToeStateModel = TicTacToeStateModel.CLOSED_GAME;
    }

    public void createGame() {
        assert this.ticTacToeStateModel == TicTacToeStateModel.CLOSED_GAME;
        this.ticTacToeStateModel = TicTacToeStateModel.OPENED_GAME;
    }

    public void openGame() {
        assert this.ticTacToeStateModel == TicTacToeStateModel.CLOSED_GAME;
        this.ticTacToeStateModel = TicTacToeStateModel.OPENED_GAME;
    }

    public void logout() {
        assert this.ticTacToeStateModel == TicTacToeStateModel.CLOSED_GAME
                || this.ticTacToeStateModel == TicTacToeStateModel.CLOSED_GAME;
        this.ticTacToeStateModel = TicTacToeStateModel.FINAL;
    }

    public void placeCard(boolean existTicTacToe) {
        assert this.ticTacToeStateModel == TicTacToeStateModel.OPENED_GAME;
        if (existTicTacToe) {
            this.ticTacToeStateModel = TicTacToeStateModel.CLOSED_GAME;
        }
    }

}
