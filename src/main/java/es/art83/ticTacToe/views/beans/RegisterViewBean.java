package es.art83.ticTacToe.views.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean (name="registerView")
public class RegisterViewBean extends UserViewBean {
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String process() {
        if (!this.getUser().getPassword().equals(this.password2)) {
            FacesContext.getCurrentInstance().addMessage("registerView:password",
                    new FacesMessage("Claves direrentes"));
            return null;
        } else {
            boolean ok = this.getLogin().create(this.getUser());
            if (!ok) {
                FacesContext.getCurrentInstance().addMessage("registerView:user",
                        new FacesMessage("Usuario ya registrado"));
                return null;
            } else {
                this.sessionRegister();
                LogManager.getLogger(LoginController.class.getName()).info(
                        "Usuario Registrado: " + this.getUser().toString());
                return "logged/gameView";
            }
        }
    }

}
