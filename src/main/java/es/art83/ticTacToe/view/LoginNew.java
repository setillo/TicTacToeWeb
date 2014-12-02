package es.art83.ticTacToe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
                // Se añade user a la sesión
                // se prepara siguiente caso de uso...
                System.out.println("Usuario registrado: " + this.getUser());
                return null;
            }
        }
    }

}
