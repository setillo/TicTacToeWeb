package es.art83.ticTacToe.views.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean(name = "gameView")
public class GameViewBean extends ViewBean {
    private String bye = "";

    public String getBye() {
        return bye;
    }

    public String logout() {
        this.getSessionMap().put("user", null);
        LogManager.getLogger(LoginController.class.getName()).info("Sesion cerrada");
        this.bye="Bye!!";
        return "/loginView";
    }
}
