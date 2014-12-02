package es.art83.ticTacToe.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controller.Login;

@ManagedBean(name = "game")
public class GameView extends Bean {
    @ManagedProperty(value = "#{loginOld}")
    private LoginOld loginOld;

    public void setLoginOld(LoginOld loginOld) {
        this.loginOld = loginOld;
    }

    public String logout() {
        this.getSessionMap().put("user", null);
        LogManager.getLogger(Login.class.getName()).info("Sesion cerrada: ");
        this.loginOld.setBye("Bye!!");
        return "/loginOld";
    }
}
