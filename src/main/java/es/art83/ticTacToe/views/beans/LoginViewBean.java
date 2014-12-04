package es.art83.ticTacToe.views.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@ManagedBean
public class LoginViewBean extends PlayerViewBean {
    private boolean finalState;

    public boolean isFinalState() {
        return finalState;
    }

    @PostConstruct
    public void update() {
        this.finalState = this.getControllerFactory().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
    }

    public String process() {
        boolean ok = this.getControllerFactory().getLoginController().read(this.getPlayer());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginViewBean",
                    new FacesMessage("usuario o clave incorrecta"));
            return "login";
        } else {
            LogManager.getLogger(LoginController.class.getName()).info(
                    "Usuario Logeado: " + this.getPlayer().toString());

            return "logged/game";
        }

    }

}
