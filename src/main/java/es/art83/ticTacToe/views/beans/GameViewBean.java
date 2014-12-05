package es.art83.ticTacToe.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@ManagedBean
public class GameViewBean extends ViewBean {

    private List<String> gameNames;

    private String gameNameSelected;

    private boolean openedGame;

    @PostConstruct
    public void update() {
        this.openedGame = this.getControllerFactory().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        this.gameNames = this.getControllerFactory().getStartGameController().readGameNames();
        LogManager.getLogger(OpenGameController.class.getName()).info(
                "Open game: consultando partidas" + this.gameNames);
    }

    public String getGameNameSelected() {
        return gameNameSelected;
    }

    public void setGameNameSelected(String gameNameSelected) {
        this.gameNameSelected = gameNameSelected;
    }

    public List<String> getGameNames() {
        return this.gameNames;
    }

    public boolean isOpenedGame() {
        return this.openedGame;
    }

    public boolean hasGames() {
        return this.gameNames.size() > 0;
    }

    public String createGame() {
        this.getControllerFactory().getCreateGameControler().createGame();
        this.openedGame = true;
        LogManager.getLogger(CreateGameController.class.getName()).info("Creado game");
        return null;
    }

    public String openGame() {
        LogManager.getLogger(OpenGameController.class.getName()).info(
                "Open game: " + this.gameNameSelected);
        return null;
    }

    public String logout() {
        this.getControllerFactory().getLogoutController().logout();
        LogManager.getLogger(LogoutController.class.getName()).info("Usuario cerrado");
        return "/login";
    }
}
