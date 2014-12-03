package es.art83.ticTacToe.views.beans;

import javax.faces.bean.ManagedProperty;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.UserEntity;

public class UserViewBean extends ViewBean {
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    private UserEntity user = new UserEntity();

    public LoginController getLogin() {
        return login;
    }
    
    public void setLogin(LoginController login) {
        this.login = login;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

  
    public void sessionRegister(){
        this.getSessionMap().put("user", this.user.getUser());
    }

}
