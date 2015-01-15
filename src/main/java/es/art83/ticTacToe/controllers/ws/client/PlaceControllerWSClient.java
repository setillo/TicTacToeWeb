package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;

public class PlaceControllerWSClient extends ControllerWSClient implements PlaceCardController {

    public PlaceControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void placeCard(CoordinateEntity coordinateEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        // TODO Auto-generated method stub

    }

}
