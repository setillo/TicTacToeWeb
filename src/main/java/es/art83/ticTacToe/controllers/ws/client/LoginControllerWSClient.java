package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerWSClient extends ControllerWSClient implements LoginController {

    public LoginControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public boolean login(PlayerEntity user) {
        final String PATH = "token";
        return this.getWebService().post(PATH, user);
    }

    @Override
    public boolean register(PlayerEntity user) {
        final String PATH = "user";
        boolean result = this.getWebService().post(PATH, user);
        if (result) {
            result = this.login(user);
        }
        return result;
    }

    @Override
    public boolean logged() {
        return this.getWSClientContext().getTokenEntity() != null;
    }

}
