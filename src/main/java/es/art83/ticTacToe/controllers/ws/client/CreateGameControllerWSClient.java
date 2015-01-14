package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.CreateGameController;

public class CreateGameControllerWSClient extends ControllerWSClient implements
        CreateGameController {

    public CreateGameControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public void createGame() {
        final String PATH = "game";
        this.getWebService().create(PATH, null);
    }

}
