package es.art83.ticTacToe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controller.Login;

@ManagedBean
public class LoginOld extends LoginView {
    private String bye = "";

    public String getBye() {
        return bye;
    }

    public void setBye(String bye) {
        this.bye = bye;
    }

    public String process() {
        boolean ok = this.getLogin().read(this.getUser());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginOld",
                    new FacesMessage("usuario o clave incorrecta"));
            return "loginOld";
        } else {
            this.session();
            LogManager.getLogger(Login.class.getName()).info(
                    "Usuario Logeado: " + this.getUser().toString());

            return "logged/game";
        }

    }

}
