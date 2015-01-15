package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import es.art83.ticTacToe.controllers.StartGameController;

public class StartControllerWSClient extends ControllerWSClient implements StartGameController {

    public StartControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public List<String> readGameNames() {
        // TODO Auto-generated method stub
        return null;
    }

}
