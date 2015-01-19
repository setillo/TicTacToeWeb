package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.NameGameController;

public class NameControllerWSClient extends ControllerWSClient implements NameGameController {

    public NameControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public List<String> gameNames() {
        WebTarget target = this.webTargetContext().path("gameNames");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(new GenericType<List<String>>() {
        });
    }

}
