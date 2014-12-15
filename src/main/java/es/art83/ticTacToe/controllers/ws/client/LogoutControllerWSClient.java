package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.LogoutController;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {

    public LogoutControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public void logout() {
        final String PATH = "token";
        this.getWebService().delete(
                PATH + "/" + this.getWSClientContext().getTokenEntity().getValue());
        this.getWSClientContext().setTokenEntity(null);
    }

    @Override
    public boolean isBye() {
        final String PATH = "/tictactoeContext/bye";
        return (Boolean) this.getWebService().get(PATH, Boolean.class);
    }

    @Override
    public boolean savedGame() {
        final String PATH = "/tictactoeContext/savedGame";
        return (Boolean) this.getWebService().get(PATH, Boolean.class);
    }

}
