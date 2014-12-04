package es.art83.ticTacToe.views.beans;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerViewBean extends ViewBean {

    private PlayerEntity playerEntity = new PlayerEntity();

    public PlayerEntity getPlayer() {
        return playerEntity;
    }

    public void setPlayer(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

}
