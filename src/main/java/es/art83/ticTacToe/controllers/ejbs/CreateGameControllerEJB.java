package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class CreateGameControllerEJB extends ControllerEJB implements CreateGameController {

    public CreateGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void createGame() {
        assert this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME;
        this.getTicTacToeContext().setGame(new GameEntity(this.getTicTacToeContext().getPlayer()));
        this.getTicTacToeContext().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }

}
