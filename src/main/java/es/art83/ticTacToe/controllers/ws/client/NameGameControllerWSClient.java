package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import es.art83.ticTacToe.controllers.NameGameController;

public class NameGameControllerWSClient extends ControllerWSClient implements NameGameController {

    public NameGameControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> gameNames() {
        final String PATH = "game.name";
        return (List<String>) this.getWebService().gets(PATH);
     }

}
