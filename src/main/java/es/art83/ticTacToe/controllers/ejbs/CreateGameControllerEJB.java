package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class CreateGameControllerEJB extends ControllerEJB implements CreateGameController {

    public CreateGameControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void createGame() {
        assert this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME;
        this.getTicTacToeStatesManager().setGame(new GameEntity(this.getTicTacToeStatesManager().getPlayer()));
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }

}
