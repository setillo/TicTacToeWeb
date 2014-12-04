package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class TicTacToeStatesManager {
    private TicTacToeStateModel ticTacToeStateModel;

    private PlayerEntity player;

    public TicTacToeStateModel getTicTacToeStateModel() {
        return this.ticTacToeStateModel;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public TicTacToeStatesManager() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
    }

    public void login(PlayerEntity player) {
        assert this.ticTacToeStateModel == TicTacToeStateModel.INITIAL
                || this.ticTacToeStateModel == TicTacToeStateModel.FINAL;
        this.player = player;
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
        this.player = null;
        this.ticTacToeStateModel = TicTacToeStateModel.FINAL;
    }

    public void placeCard(boolean existTicTacToe) {
        assert this.ticTacToeStateModel == TicTacToeStateModel.OPENED_GAME;
        if (existTicTacToe) {
            this.ticTacToeStateModel = TicTacToeStateModel.CLOSED_GAME;
        }
    }

}
