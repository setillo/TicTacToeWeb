package es.art83.ticTacToe.views.beans;

import javax.faces.bean.ManagedProperty;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerViewBean extends ViewBean {
    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;

    private PlayerEntity playerEntity = new PlayerEntity();

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public LoginController getLoginController() {
        return loginController;
    }
    
    public PlayerEntity getPlayer() {
        return playerEntity;
    }

    public void setPlayer(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public void sessionRegister(){
        this.getSessionMap().put("user", this.playerEntity.getUser());
    }

}
