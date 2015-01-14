package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.SaveGameController;

public class SaveGameControllerWSClient extends ControllerWSClient implements SaveGameController {
    final String PATH = "game";

    public SaveGameControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        super(webService, wSClientContext);
    }

    @Override
    public void saveGame(String gameName) {
        this.getWebService().create(PATH, gameName);
    }

    @Override
    public void overWriteGame(String gameName) {
        this.getWebService().put(PATH, gameName);
    }

    @Override
    public void saveGame() {
        this.getWebService().put(PATH, null);
    }

}
