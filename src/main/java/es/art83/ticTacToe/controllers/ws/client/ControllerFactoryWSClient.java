package es.art83.ticTacToe.controllers.ws.client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerFactoryWSClient extends ControllerFactory {

    private LoginController loginController;

    private LogoutController logoutController;

    private StartGameController startGameController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private NameGameController nameGameController;

    private ShowGameController showGameController;

    private PlaceCardController placeCardController;

    private SaveGameController saveGameController;

    public ControllerFactoryWSClient() {
        Integer contextId = null;
        // Crear peticion rest para crear contexto. Almacenar la referencia del
        // contexto en el servidor
        WebTarget target = ControllerWSClient.webTargetServer().path("contexts");
        Response response = target.request().post(null);
        contextId = response.readEntity(Integer.class);

        // Pasarle la referencia a todos los controladores
        this.loginController = new LoginControllerWSClient(contextId);
        this.logoutController = new LogoutControllerWSClient(contextId);
        this.startGameController = new StartControllerWSClient(contextId);
        this.createGameController = new CreateControllerWSClient(contextId);
        this.nameGameController = new NameControllerWSClient(contextId);
        this.showGameController = new ShowGameControllerWSClient(contextId);
        this.placeCardController = new PlaceControllerWSClient(contextId);
        this.saveGameController = new SaveControllerWSClient(contextId);
        this.openGameController = new OpenControllerWSClient(contextId);
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
