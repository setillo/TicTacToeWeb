package es.art83.ticTacToe.views.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean
public class LoginViewBean extends UserViewBean {

    public String process() {
        boolean ok = this.getLogin().read(this.getUser());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginViewBean",
                    new FacesMessage("usuario o clave incorrecta"));
            return "login";
        } else {
            this.sessionRegister();
            LogManager.getLogger(LoginController.class.getName()).info(
                    "Usuario Logeado: " + this.getUser().toString());

            return "logged/game";
        }

    }

}
