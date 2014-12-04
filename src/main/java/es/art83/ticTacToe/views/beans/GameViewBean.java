package es.art83.ticTacToe.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;

@ManagedBean
public class GameViewBean extends ViewBean {

    private List<String> gameNames;

    private String gameNameSelected;

    @PostConstruct
    public void update() {
        this.gameNames = new ArrayList<String>();
        this.gameNames.add("uno");
        this.gameNames.add("dos");
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
        return gameNames;
    }

    public boolean existTicTacToe() {
        return true;
    }

    public boolean hasGames() {
        return this.gameNames.size() > 0;
    }

    public String createGame() {
        LogManager.getLogger(CreateGameController.class.getName()).info("Creando game");
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
