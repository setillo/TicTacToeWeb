package es.art83.ticTacToe.controllers.ws.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ControllerWSClient {
    private Integer contextId = null;

    public ControllerWSClient(Integer contextId) {
        this.contextId = contextId;
    }

    protected Integer getContextId() {
        return contextId;
    }

    protected static WebTarget webTargetServer() {
        return ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest");
    }

    protected WebTarget webTargetContext() {
        return webTargetServer().path("contexts").path(String.valueOf(this.getContextId()));
    }
}
