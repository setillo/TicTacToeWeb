package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class TicTacToeApplicationManager {
    private TicTacToeStateModel ticTacToeStateModel;

    private PlayerEntity player;

    private GameEntity game;

    private boolean saved;

    public TicTacToeApplicationManager() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
        this.player = null;
        this.game = null;
        this.saved = false;
    }

    protected TicTacToeStateModel getTicTacToeStateModel() {
        return ticTacToeStateModel;
    }

    protected void setTicTacToeStateModel(TicTacToeStateModel ticTacToeStateModel) {
        this.ticTacToeStateModel = ticTacToeStateModel;
    }

    protected PlayerEntity getPlayer() {
        return player;
    }

    protected void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    protected GameEntity getGame() {
        return game;
    }

    protected void setGame(GameEntity game) {
        this.game = game;
    }

    protected boolean isSavedGame() {
        return saved;
    }

    protected void setSaved(boolean saved) {
        this.saved = saved;
    }
    
    public void openGame() {
        assert this.ticTacToeStateModel == TicTacToeStateModel.CLOSED_GAME;
        this.ticTacToeStateModel = TicTacToeStateModel.OPENED_GAME;
    }

    public void placeCard(boolean existTicTacToe) {
        assert this.ticTacToeStateModel == TicTacToeStateModel.OPENED_GAME;
        if (existTicTacToe) {
            this.ticTacToeStateModel = TicTacToeStateModel.CLOSED_GAME;
        }
    }

}
