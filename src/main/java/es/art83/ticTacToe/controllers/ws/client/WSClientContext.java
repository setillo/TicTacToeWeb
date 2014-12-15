package es.art83.ticTacToe.controllers.ws.client;

public class WSClientContext {
    private TokenEntity tokenEntity;

    protected TokenEntity getTokenEntity() {
        return tokenEntity;
    }

    protected void setTokenEntity(TokenEntity tokenEntity) {
        this.tokenEntity = tokenEntity;
    }
}
