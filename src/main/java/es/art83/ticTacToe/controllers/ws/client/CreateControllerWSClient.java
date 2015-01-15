package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.CreateGameController;

public class CreateControllerWSClient extends ControllerWSClient implements CreateGameController {

    public CreateControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public void createGame() {
        // TODO Auto-generated method stub

    }

}
