package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class ShowControllerWSClient extends ControllerWSClient implements ShowGameController {

    public ShowControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public String getNameGame() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ColorModel[][] completeBoard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ColorModel winner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSavedGame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ColorModel turnColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isFullBoard() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean createdGame() {
        // TODO Auto-generated method stub
        return false;
    }

}
