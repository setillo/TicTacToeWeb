package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.LogoutController;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {

    public LogoutControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void logout() {
        WebTarget target = ControllerWSClient.webTargetServer().path("player");
        Response response = target.request().delete();
        response.close();
    }

    @Override
    public boolean isBye() {
        WebTarget target = this.webTargetContext().path("isBye");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return Boolean.valueOf(response.readEntity(String.class)); // response.close()
    }

    @Override
    public boolean savedGame() {
        WebTarget target = this.webTargetContext().path("savedGame");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(Boolean.class); // response.close()
    }

}
