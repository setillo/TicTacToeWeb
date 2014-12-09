package es.art83.ticTacToe.controllers.ejbs;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class CreateGameControllerEJB extends ControllerEJB implements CreateGameController {

    public CreateGameControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void createGame() {
        assert this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME;
        this.getTicTacToeStatesManager().setGame(new GameEntity());
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }

}
