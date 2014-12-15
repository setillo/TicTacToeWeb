package es.art83.ticTacToe.controllers;

public abstract class ControllerFactory {
    public abstract LoginController getLoginController();

    public abstract LogoutController getLogoutController();

    public abstract CreateGameController getCreateGameControler();

    public abstract OpenGameController getOpenGameController();

    public abstract StartGameController getStartGameController();

    public abstract NameGameController getNameGameController();

    public abstract ShowGameController getShowGameController();

    public abstract PlaceCardController getPlaceCardController();

    public abstract SaveGameController getSaveGameController();
}
