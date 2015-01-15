package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerWSClient extends ControllerWSClient implements LoginController {

    public LoginControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        boolean result = false;
        WebTarget target = this.webTargetContext().path("player");
        Response response = target.request().post(Entity.xml(playerEntity));
        if (Response.Status.OK.equals(response.getStatus())) {
            result = true;
        } else {
            response.close();
        }
        return result;
    }

    @Override
    public boolean register(PlayerEntity playerEntity) {
        boolean result = false;
        WebTarget target = ControllerWSClient.webTargetServer().path("players");
        Response response = target.request().post(Entity.xml(playerEntity));
        if (Response.Status.OK.equals(response.getStatus())) {
            this.login(playerEntity);
            result = this.login(playerEntity);
        } else {
            response.close();
        }
        return result;
    }

    @Override
    public boolean logged() {
        WebTarget target = this.webTargetContext().path("logged");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        return response.readEntity(Boolean.class); // response.close()
    }

}
