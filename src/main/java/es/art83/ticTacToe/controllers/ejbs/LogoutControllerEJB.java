package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LogoutController;

public class LogoutControllerEJB extends ControllerEJB implements LogoutController {

    public LogoutControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void logout() {
        this.getTicTacToeStatesManager().logout();
    }

}
