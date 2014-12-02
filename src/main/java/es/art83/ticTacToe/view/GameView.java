package es.art83.ticTacToe.view;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controller.Login;

@ManagedBean(name = "game")
public class GameView extends Bean {
    private String bye = "";

    public String getBye() {
        return bye;
    }

    public String logout() {
        this.getSessionMap().put("user", null);
        LogManager.getLogger(Login.class.getName()).info("Sesion cerrada");
        this.bye="Bye!!";
        return "/loginOld";
    }
}
