package es.art83.ticTacToe.view;

import java.util.Map;

import javax.faces.bean.ManagedProperty;

import es.art83.ticTacToe.controller.Login;
import es.art83.ticTacToe.model.entities.User;

public class LoginView extends Bean {
    @ManagedProperty(value = "#{login}")
    private Login login;

    @ManagedProperty(value = "#{sessionScope}")
    private Map<String, Object> sessionMap;

    private User user = new User();

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Login getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public void session(){
        this.sessionMap.put("user", this.user.getUser());
    }

}
