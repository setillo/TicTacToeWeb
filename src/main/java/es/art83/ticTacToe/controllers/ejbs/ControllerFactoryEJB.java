package es.art83.ticTacToe.controllers.ejbs;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.StartGameController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@ManagedBean(name="controllerFactory")
@SessionScoped
public class ControllerFactoryEJB extends ControllerFactory {

    private TicTacToeStatesManager ticTacToeStatesManager;

    private LoginController loginController;
    
    private LogoutController logoutController;

    private StartGameController startGameController;
    
    private CreateGameController createGameController;

    //private OpenGameController openGameController;


    public ControllerFactoryEJB() {
        this.ticTacToeStatesManager = new TicTacToeStatesManager();
        this.loginController = new LoginControllerEJB(ticTacToeStatesManager);
        this.logoutController = new LogoutControllerEJB(ticTacToeStatesManager);
        this.startGameController = new StartGameControllerEJB(ticTacToeStatesManager);
        this.createGameController= new CreateGameControllerEJB(ticTacToeStatesManager);
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
        return null;
    }

    @Override
    public StartGameController getStartGameController() {
        return this.startGameController;
    }



}
