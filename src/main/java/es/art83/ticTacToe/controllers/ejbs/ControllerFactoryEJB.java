package es.art83.ticTacToe.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.NameGameController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.controllers.StartGameController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerFactoryEJB extends ControllerFactory {

    private TicTacToeStatesManager ticTacToeStatesManager;

    private LoginController loginController;

    private LogoutController logoutController;

    private StartGameController startGameController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private NameGameController nameGameController;

    private ShowGameController showGameController;

    private PlaceCardController placeCardController;

    private SaveGameController saveGameController;

    public ControllerFactoryEJB() {
        this.ticTacToeStatesManager = new TicTacToeStatesManager();
        this.loginController = new LoginControllerEJB(ticTacToeStatesManager);
        this.logoutController = new LogoutControllerEJB(ticTacToeStatesManager);
        this.startGameController = new StartGameControllerEJB(ticTacToeStatesManager);
        this.createGameController = new CreateGameControllerEJB(ticTacToeStatesManager);
        this.nameGameController = new NameGameControllerEJB(ticTacToeStatesManager);
        this.showGameController = new ShowGameControllerEJB(ticTacToeStatesManager);
        this.placeCardController = new PlaceCardControllerEJB(ticTacToeStatesManager);
        this.saveGameController = new SaveGameControllerEJB(ticTacToeStatesManager);
        this.openGameController = new OpenGameControllerEJB(ticTacToeStatesManager);
    }

    @Override
    public TicTacToeStateModel getTicTacToeStateModel() {
        return this.ticTacToeStatesManager.getTicTacToeStateModel();
    }

    @Override
    public LoginController getLoginController() {
        return this.loginController;
    }

    @Override
    public LogoutController getLogoutController() {
        return this.logoutController;
    }

    @Override
    public CreateGameController getCreateGameControler() {
        return createGameController;
    }

    @Override
    public OpenGameController getOpenGameController() {
        return this.openGameController;
    }

    @Override
    public StartGameController getStartGameController() {
        return this.startGameController;
    }

    @Override
    public NameGameController getNameGameController() {
        return this.nameGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        return this.showGameController;
    }

    @Override
    public PlaceCardController getPlaceCardController() {
        return this.placeCardController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        return this.saveGameController;
    }

}
