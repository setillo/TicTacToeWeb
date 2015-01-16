package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.CreateGameController;

public class CreateControllerWSClient extends ControllerWSClient implements CreateGameController {

    public CreateControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void createGame() {
        WebTarget target = this.webTargetContext().path("game");
        Response response = target.request().post(null);
        response.close();
    }

}
