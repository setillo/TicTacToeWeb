package es.art83.ticTacToe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controller.Login;

@ManagedBean
public class LoginNew extends LoginView {
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String process() {
        if (!this.getUser().getPassword().equals(this.password2)) {
            FacesContext.getCurrentInstance().addMessage("loginNew:password",
                    new FacesMessage("Claves direrentes"));
            return null;
        } else {
            boolean ok = this.getLogin().create(this.getUser());
            if (!ok) {
                FacesContext.getCurrentInstance().addMessage("loginNew:user",
                        new FacesMessage("Usuario ya registrado"));
                return null;
            } else {
                this.session();
                LogManager.getLogger(Login.class.getName()).info(
                        "Usuario Registrado: " + this.getUser().toString());
                return "logged/game";
            }
        }
    }

}
