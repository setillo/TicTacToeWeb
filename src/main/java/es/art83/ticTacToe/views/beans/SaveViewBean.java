package es.art83.ticTacToe.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.SaveGameController;

@ManagedBean
public class SaveViewBean extends ViewBean {
    private List<String> gameNames;

    private String gameName;

    private boolean overWrite = false;

    @PostConstruct
    public void update() {
        this.gameNames = this.getControllerFactory().getSaveGameController().gameNames();
    }

    public boolean isOverWrite() {
        return this.overWrite;
    }

    public List<String> getGameNames() {
        return gameNames;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean isZeroGameNames() {
        return this.gameNames.size() == 0;
    }

    public String saveGame() {
        String next = null;
        if (this.gameNames.contains(this.gameName)) {
            FacesContext.getCurrentInstance().addMessage("over",
                    new FacesMessage("Game name exist!!!"));
            this.overWrite = true;
        } else {
            SaveGameController saveGameController = this.getControllerFactory()
                    .getSaveGameController();
            saveGameController.saveGame(this.gameName);
            LogManager.getLogger(saveGameController.getClass().getName()).info(
                    "Partida salvada: " + this.gameName);
            next = "game";
        }
        return next;
    }

    public String overWriteGame() {
        SaveGameController saveGameController = this.getControllerFactory().getSaveGameController();
        saveGameController.overWriteGame();
        LogManager.getLogger(saveGameController.getClass().getName()).info(
                "Partida sobrescrita: " + this.gameName);
        return "game";
    }

}
