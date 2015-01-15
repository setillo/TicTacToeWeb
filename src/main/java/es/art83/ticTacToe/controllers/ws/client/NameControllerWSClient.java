package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import es.art83.ticTacToe.controllers.NameGameController;

public class NameControllerWSClient extends ControllerWSClient implements NameGameController {

    public NameControllerWSClient(Integer contextId) {
        super(contextId);
    }

    @Override
    public List<String> gameNames() {
        // TODO Auto-generated method stub
        return null;
    }

}
