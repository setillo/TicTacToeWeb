package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class ShowGameControllerEJB extends ControllerEJB implements ShowGameController {

    public ShowGameControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public String getNameGame() {
        return this.getTicTacToeStatesManager().getGame().getName();
    }

    @Override
    public ColorModel[][] completeBoard() {
        return this.getTicTacToeStatesManager().getGame().completeBoard();
    }

    @Override
    public boolean isGameOver() {
        return this.getTicTacToeStatesManager().getGame().isGameOver();
    }

    @Override
    public ColorModel winner() {
        return this.getTicTacToeStatesManager().getGame().winner();
    }

    @Override
    public boolean isSavedGame() {
        return this.getTicTacToeStatesManager().isSavedGame();
    }

    @Override
    public ColorModel turnColor() {
        return this.getTicTacToeStatesManager().getGame().turnColor();
    }

    @Override
    public boolean isFullBoard() {
        return  this.getTicTacToeStatesManager().getGame().isFullBoard();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        return  this.getTicTacToeStatesManager().getGame().validSourceCoordinates();
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        return  this.getTicTacToeStatesManager().getGame().validDestinationCoordinates();
    }

}
