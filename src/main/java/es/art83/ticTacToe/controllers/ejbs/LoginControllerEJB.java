package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerEJB extends ControllerEJB implements LoginController {

    public LoginControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public boolean read(PlayerEntity user) {
        PlayerEntity userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD != null && userBD.getPassword().equals(user.getPassword())) {
            this.getTicTacToeStatesManager().login();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean create(PlayerEntity user) {
        PlayerEntity userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD == null) {
            DAOFactory.getFactory().getUserDAO().create(user);
            this.getTicTacToeStatesManager().login();
            return true;
        } else {
            return false;
        }
    }

}
