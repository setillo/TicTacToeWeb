package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerWSClient extends ControllerWSClient implements LoginController {

    public LoginControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        final String PATH = "tokens";
        boolean result = this.getWebService().create(PATH, playerEntity);
        return result;
    }

    @Override
    public boolean register(PlayerEntity playerEntity) {
        final String PATH = "players";
        boolean result = this.getWebService().create(PATH, playerEntity);
        if (result) {
            result = this.login(playerEntity);
        }
        return result;
    }

    @Override
    public boolean logged() {
        return this.getWSClientContext().getTokenEntity() != null;
    }

}
