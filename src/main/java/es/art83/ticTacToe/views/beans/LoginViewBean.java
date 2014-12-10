package es.art83.ticTacToe.views.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;

@ManagedBean
public class LoginViewBean extends PlayerViewBean {
    private boolean bye;

    @PostConstruct
    public void update() {
        LogoutController logoutController = this.getControllerFactory().getLogoutController();
        this.bye = logoutController.isBye();
    }

    public boolean isBye() {
        return this.bye;
    }

    public String login() {
        String next = null;
        LoginController loginController = this.getControllerFactory().getLoginController();
        boolean ok = loginController.login(this.getPlayer());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginViewBean",
                    new FacesMessage("usuario o clave incorrecta"));
        } else {
            LogManager.getLogger(loginController.getClass().getName()).info(
                    "Usuario Logeado: " + this.getPlayer().toString());

            next = "logged/game";
        }
        return next;
    }

}
