package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;

public class PlaceControllerWSClient extends ControllerWSClient implements PlaceCardController {

    public PlaceControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void placeCard(CoordinateEntity coordinateEntity) {
        WebTarget target = this.webTargetContext().path("game").path("piece");
        target.request().post(Entity.xml(coordinateEntity));
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        WebTarget target = this.webTargetContext().path("game").path("piece");
        target = target.matrixParam("row", source.getRow()).matrixParam("column",
                source.getColumn());
        target.request().delete();
        target.request().post(Entity.xml(destination));
    }

}
