package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.OpenGameController;

public class OpenControllerWSClient extends ControllerWSClient implements OpenGameController {

    public OpenControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void openGame(String gameNameSelected) {
        WebTarget target = this.webTargetContext().path("game");
        Response response = target.request().post(Entity.xml(gameNameSelected));
        response.close();
    }

}
