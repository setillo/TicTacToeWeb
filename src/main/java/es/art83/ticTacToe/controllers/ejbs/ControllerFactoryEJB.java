package es.art83.ticTacToe.controllers.ejbs;

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

//@ManagedBean(name = "controllerFactory")
//@SessionScoped
public class ControllerFactoryEJB extends ControllerFactory {

    private TicTacToeContext ticTacToeContext;

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
        this.ticTacToeContext = new TicTacToeContext();
        this.loginController = new LoginControllerEJB(ticTacToeContext);
        this.logoutController = new LogoutControllerEJB(ticTacToeContext);
        this.startGameController = new StartGameControllerEJB(ticTacToeContext);
        this.createGameController = new CreateGameControllerEJB(ticTacToeContext);
        this.nameGameController = new NameGameControllerEJB(ticTacToeContext);
        this.showGameController = new ShowGameControllerEJB(ticTacToeContext);
        this.placeCardController = new PlaceCardControllerEJB(ticTacToeContext);
        this.saveGameController = new SaveGameControllerEJB(ticTacToeContext);
        this.openGameController = new OpenGameControllerEJB(ticTacToeContext);
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
