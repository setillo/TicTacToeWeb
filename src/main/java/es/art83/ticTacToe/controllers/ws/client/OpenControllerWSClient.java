package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.OpenGameController;

public class OpenControllerWSClient extends ControllerWSClient implements OpenGameController {

    public OpenControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void openGame(String gameNameSelected) {
        // TODO Auto-generated method stub

    }

}
