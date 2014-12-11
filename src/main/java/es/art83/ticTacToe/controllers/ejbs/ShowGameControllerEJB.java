package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class ShowGameControllerEJB extends ControllerEJB implements ShowGameController {

    public ShowGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public String getNameGame() {
        return this.getTicTacToeContext().getGame().getName();
    }

    @Override
    public ColorModel[][] completeBoard() {
        return this.getTicTacToeContext().getGame().completeBoard();
    }

    @Override
    public boolean isGameOver() {
        return this.getTicTacToeContext().getGame().isGameOver();
    }

    @Override
    public ColorModel winner() {
        return this.getTicTacToeContext().getGame().winner();
    }

    @Override
    public boolean isSavedGame() {
        return this.getTicTacToeContext().isSavedGame();
    }

    @Override
    public ColorModel turnColor() {
        return this.getTicTacToeContext().getGame().turnColor();
    }

    @Override
    public boolean isFullBoard() {
        return this.getTicTacToeContext().getGame().isFullBoard();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        return this.getTicTacToeContext().getGame().validSourceCoordinates();
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.getTicTacToeContext().getGame().validDestinationCoordinates();
    }

    @Override
    public boolean createdGame() {
        boolean result = this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        result = result || this.getTicTacToeContext().getGame() != null;
        return result;
    }

}
