package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;

public class PlaceCardControllerEJB extends ControllerEJB implements PlaceCardController {

    public PlaceCardControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void placeCard(CoordinateEntity coordinateEntity) {
        this.getTicTacToeStatesManager().getGame().placeCard(coordinateEntity);
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.getTicTacToeStatesManager().getGame().placeCard(source,destination);
        
    }

}
