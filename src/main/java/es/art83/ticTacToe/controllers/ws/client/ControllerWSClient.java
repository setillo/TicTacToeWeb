package es.art83.ticTacToe.controllers.ws.client;

public class ControllerWSClient {
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
