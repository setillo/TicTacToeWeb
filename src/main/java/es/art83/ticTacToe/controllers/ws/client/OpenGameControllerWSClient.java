package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.OpenGameController;

public class OpenGameControllerWSClient extends ControllerWSClient implements OpenGameController {

    public OpenGameControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public void openGame(String gameNameSelected) {
        // TODO Auto-generated method stub

    }

}
