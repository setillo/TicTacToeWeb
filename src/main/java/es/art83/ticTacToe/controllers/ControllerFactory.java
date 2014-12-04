package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public abstract class ControllerFactory {
    public abstract TicTacToeStateModel getTicTacToeStateModel();

    public abstract LoginController getLoginController();
    
    public abstract LogoutController getLogoutController();
    
    public abstract CreateGameController getCreateGameControler();

    public abstract OpenGameController getOpenGameController();

    public abstract StartGameController getStartGameController();

}
