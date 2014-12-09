package es.art83.ticTacToe.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@ManagedBean
public class GameViewBean extends ViewBean {

    private List<String> gameNames;

    private String gameNameSelected;

    private boolean openedGame;

    private String nameGame;

    private ColorModel[][] fichas;

    private boolean gameOver;

    private ColorModel winner;

    private boolean savedGame;

    private ColorModel turn;

    private boolean fullBoard;

    private List<CoordinateEntity> validSourceCoordinates;

    private String selectedSourceCoordinate;

    private List<CoordinateEntity> validDestinationCoordinates;

    private String selectedDestinationCoordinate;

    @PostConstruct
    public void update() {
        this.openedGame = this.getControllerFactory().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        if (this.openedGame) {
            this.nameGame = this.getControllerFactory().getShowGameController().getNameGame();
            this.fichas = this.getControllerFactory().getShowGameController().completeBoard();
            this.gameOver = this.getControllerFactory().getShowGameController().isGameOver();
            if (this.gameOver) {
                this.winner = this.getControllerFactory().getShowGameController().winner();
            } else {
                this.savedGame = this.getControllerFactory().getShowGameController().isSavedGame();
                this.turn = this.getControllerFactory().getShowGameController().turnColor();
                // Se actualiza validSourceCoordinates
                this.fullBoard = this.getControllerFactory().getShowGameController().isFullBoard();
                if (this.fullBoard) {
                    this.validSourceCoordinates = this.getControllerFactory().getShowGameController().validSourceCoordinates();
                }
                // Se actualiza validDestinationCoordinates
                this.validDestinationCoordinates = this.getControllerFactory().getShowGameController().validDestinationCoordinates();
            }
        }
        this.gameNames = this.getControllerFactory().getStartGameController().readGameNames();
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

    public boolean isZeroGameNames() {
        return this.gameNames.size() == 0;
    }

    public boolean isGameNamed() {
        return this.nameGame != null;
    }

    public String getNameGame() {
        return this.nameGame;
    }

    public ColorModel[][] getFichas() {
        return fichas;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public ColorModel getWinner() {
        return winner;
    }

    public boolean isSavedGame() {
        return savedGame;
    }

    public ColorModel getTurn() {
        return turn;
    }

    public boolean isFullBoard() {
        return fullBoard;
    }

    public List<CoordinateEntity> getValidSourceCoordinates() {
        return validSourceCoordinates;
    }

    public String getSelectedSourceCoordinate() {
        return selectedSourceCoordinate;
    }

    public void setSelectedSourceCoordinate(String selectedSourceCoordinate) {
        this.selectedSourceCoordinate = selectedSourceCoordinate;
    }

    public List<CoordinateEntity> getValidDestinationCoordinates() {
        return validDestinationCoordinates;
    }

    public String getSelectedDestinationCoordinate() {
        return selectedDestinationCoordinate;
    }

    public void setSelectedDestinationCoordinate(String selectedDestinationCoordinate) {
        this.selectedDestinationCoordinate = selectedDestinationCoordinate;
    }

    // Process
    public String createGame() {
        this.getControllerFactory().getCreateGameControler().createGame();
        this.update();
        LogManager.getLogger(CreateGameController.class.getName()).info("Creado game");
        return null;
    }

    public String openGame() {
        LogManager.getLogger(OpenGameController.class.getName()).info(
                "Open game: " + this.gameNameSelected);
        return null;
    }

    public String saveGame() {
        LogManager.getLogger(SaveGameController.class.getName()).info("Save game");
        return null;
    }

    public String placeCard() {
        LogManager.getLogger(PlaceCardController.class.getName()).info("Place card");
        return null;
    }

    public String logout() {
        this.getControllerFactory().getLogoutController().logout();
        LogManager.getLogger(LogoutController.class.getName()).info("Usuario cerrado");
        return "/login";
    }
}
