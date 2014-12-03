package es.art83.ticTacToe.views.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean
public class RegisterViewBean extends PlayerViewBean {
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String process() {
        if (!this.getPlayer().getPassword().equals(this.password2)) {
            FacesContext.getCurrentInstance().addMessage("registerViewBean:password",
                    new FacesMessage("Claves direrentes"));
            return null;
        } else {
            boolean ok = this.getLoginController().create(this.getPlayer());
            if (!ok) {
                FacesContext.getCurrentInstance().addMessage("registerViewBean:user",
                        new FacesMessage("Usuario ya registrado"));
                return null;
            } else {
                this.sessionRegister();
                LogManager.getLogger(LoginController.class.getName()).info(
                        "Usuario Registrado: " + this.getPlayer().toString());
                return "logged/game";
            }
        }
    }

}
