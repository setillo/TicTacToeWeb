package es.art83.ticTacToe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginOld extends LoginView {

    public String process() {
        boolean ok = this.getLogin().read(this.getUser());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginOld",
                    new FacesMessage("usuario o clave incorrecta"));
            return "loginOld";
        } else {
            // Se añade user a la sesión
            // se prepara siguiente caso de uso...
            System.out.println("Usuario registrado: " + this.getUser());
            return null;
        }

    }

}
