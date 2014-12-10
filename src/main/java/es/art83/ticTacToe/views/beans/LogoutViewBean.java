package es.art83.ticTacToe.views.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LogoutController;

@ManagedBean
public class LogoutViewBean extends PlayerViewBean {
    public String logout() {
        LogoutController logoutController = this.getControllerFactory().getLogoutController();
        logoutController.logout();
        LogManager.getLogger(logoutController.getClass().getName()).info("Usuario cerrado");
        return "/login";
    }

}
