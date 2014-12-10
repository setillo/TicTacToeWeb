package es.art83.ticTacToe.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

@ManagedBean
public class GameViewBean extends ViewBean {

    private List<String> gameNames;

    private String gameNameSelected;

    private boolean createdGame;

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
        ShowGameController showGameController = this.getControllerFactory().getShowGameController();
        this.createdGame = showGameController.createdGame();
        if (this.createdGame) {
            this.nameGame = this.getControllerFactory().getShowGameController().getNameGame();
            this.fichas = this.getControllerFactory().getShowGameController().completeBoard();
            this.gameOver = this.getControllerFactory().getShowGameController().isGameOver();
            if (this.gameOver) {
                this.winner = this.getControllerFactory().getShowGameController().winner();
            } else {
                this.savedGame = this.getControllerFactory().getShowGameController().isSavedGame();
                this.turn = this.getControllerFactory().getShowGameController().turnColor();
                this.fullBoard = this.getControllerFactory().getShowGameController().isFullBoard();
                if (this.fullBoard) {
                    this.validSourceCoordinates = this.getControllerFactory()
                            .getShowGameController().validSourceCoordinates();
                }
                this.validDestinationCoordinates = this.getControllerFactory()
                        .getShowGameController().validDestinationCoordinates();
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

    public boolean isCreatedGame() {
        return this.createdGame;
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
        return this.selectedDestinationCoordinate;
    }

    public void setSelectedDestinationCoordinate(String selectedDestinationCoordinate) {
        this.selectedDestinationCoordinate = selectedDestinationCoordinate;
    }

    // P R O C E S S -------- ---------- ---------- ---------- ----------
    public String createGame() {
        CreateGameController createGameController = this.getControllerFactory()
                .getCreateGameControler();
        createGameController.createGame();
        this.update();
        LogManager.getLogger(createGameController.getClass().getName()).info("Creado game");
        return null;
    }

    public String logout() {
        String next = null;
        LogoutController logoutController = this.getControllerFactory().getLogoutController();
        if (!logoutController.savedGame()) {
            next = "logout";
        } else {
            logoutController.logout();
            LogManager.getLogger(logoutController.getClass().getName()).info("Usuario cerrado");
            next = "/login";
        }
        return next;
    }

    public String placeCard() {
        PlaceCardController placeCardController = this.getControllerFactory()
                .getPlaceCardController();
        if (this.fullBoard) {
            placeCardController.placeCard(new CoordinateEntity(this.selectedSourceCoordinate),
                    new CoordinateEntity(this.selectedDestinationCoordinate));
        } else {
            placeCardController.placeCard(new CoordinateEntity(this.selectedDestinationCoordinate));
        }
        LogManager.getLogger(placeCardController.getClass().getName()).info("Place card");
        this.update();
        return null;
    }

    public String saveGame() {
        return "save";
    }

    public String openGame() {
        OpenGameController openGameController = this.getControllerFactory().getOpenGameController();
        openGameController.openGame(this.gameNameSelected);
        this.update();
        LogManager.getLogger(openGameController.getClass().getName()).info("openGame");
        return null;
    }

}
