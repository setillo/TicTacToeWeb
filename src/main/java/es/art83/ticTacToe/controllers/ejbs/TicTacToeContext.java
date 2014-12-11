package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class TicTacToeContext {
    private TicTacToeStateModel ticTacToeStateModel;

    private PlayerEntity player;

    private GameEntity game;

    private boolean saved;

    public TicTacToeContext() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
        this.player = null;
        this.game = null;
        this.saved = true;
    }

    protected TicTacToeStateModel getTicTacToeStateModel() {
        return this.ticTacToeStateModel;
    }

    protected void setTicTacToeStateModel(TicTacToeStateModel ticTacToeStateModel) {
        this.ticTacToeStateModel = ticTacToeStateModel;
    }

    protected PlayerEntity getPlayer() {
        return this.player;
    }

    protected void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    protected GameEntity getGame() {
        return this.game;
    }

    protected void setGame(GameEntity game) {
        this.game = game;
    }

    protected boolean isSavedGame() {
        return this.saved;
    }

    protected void setSaved(boolean saved) {
        this.saved = saved;
    }
    
}
