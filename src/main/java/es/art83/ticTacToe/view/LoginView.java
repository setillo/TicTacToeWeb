package es.art83.ticTacToe.view;

import javax.faces.bean.ManagedProperty;

import es.art83.ticTacToe.controller.Login;
import es.art83.ticTacToe.model.entities.User;

public class LoginView extends Bean {
    @ManagedProperty(value = "#{login}")
    private Login login;

    private User user = new User();

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

}
