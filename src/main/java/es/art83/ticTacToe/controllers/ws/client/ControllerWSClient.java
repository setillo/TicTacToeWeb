package es.art83.ticTacToe.controllers.ws.client;

public class ControllerWSClient {
    protected static final String URI = "http://localhost:8080/TicTacToe/rest";
    private WebService webService;
    private WSClientContext wSClientContext;
    

    public ControllerWSClient(WebService webService, WSClientContext wSClientContext) {
        this.wSClientContext = wSClientContext;
        this.webService = webService;
    }


    protected WebService getWebService() {
        return this.webService;
    }


    protected WSClientContext getWSClientContext() {
        return this.wSClientContext;
    }


}
