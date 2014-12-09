package es.art83.ticTacToe.views.beans;

import java.util.ArrayList;
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

    private boolean gameNamed;

    private String nameGame;

    private String[][] fichas;

    private boolean gameOver;

    private ColorModel winner;

    private boolean savedGame;

    private ColorModel turn;

    private boolean sixCardOnBoard;

    private List<CoordinateEntity> validSourceCoordinates;
    
    private String selectedSourceCoordinate;

    private List<CoordinateEntity> validDestinationCoordinates;

    private String selectedDestinationCoordinate;

    @PostConstruct
    public void update() {
        this.openedGame = this.getControllerFactory().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        this.gameNames = this.getControllerFactory().getStartGameController().readGameNames();
        // Se actualiza nameGame
        this.gameNamed = true;
        this.nameGame = "Juego...";
        // Se actualiza fichas
        this.fichas = new String[][] { {"--", "X", "--"}, {"X", "--", "--"}, {"O", "--", "--"}};
        LogManager.getLogger(OpenGameController.class.getName()).info(
                "Open game: consultando partidas" + this.gameNames);
        // Se actualiza winner
        this.gameOver = false;
        this.winner = ColorModel.O;
        // Se actualiza si la partida esta salvada
        this.savedGame = false;
        // se actualiza turno
        this.turn = ColorModel.O;
        // Se actualiza validSourceCoordinates
        this.sixCardOnBoard = true;
        this.validSourceCoordinates = new ArrayList<>();
        this.validSourceCoordinates.add(new CoordinateEntity(0, 0));
        this.validSourceCoordinates.add(new CoordinateEntity(0, 1));
        // Se actualiza validDestinationCoordinates
        this.validDestinationCoordinates = new ArrayList<>();
        this.validDestinationCoordinates.add(new CoordinateEntity(1, 0));
        this.validDestinationCoordinates.add(new CoordinateEntity(1, 1));
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
        return gameNamed;
    }

    public String getNameGame() {
        return this.nameGame;
    }

    public String[][] getFichas() {
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

    public boolean isSixCardOnBoard() {
        return sixCardOnBoard;
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
        this.openedGame = true;
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
