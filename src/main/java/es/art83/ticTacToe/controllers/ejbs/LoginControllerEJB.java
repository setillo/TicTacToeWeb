package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerEJB extends ControllerEJB implements LoginController {

    public LoginControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }


    @Override
    public boolean read(PlayerEntity player) {
        PlayerEntity playerBD = DAOFactory.getFactory().getPlayerDAO().read(player.getUser());
        if (playerBD != null && playerBD.getPassword().equals(player.getPassword())) {
            this.getTicTacToeStatesManager().login(playerBD);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean create(PlayerEntity player) {
        PlayerEntity playerBD = DAOFactory.getFactory().getPlayerDAO().read(player.getUser());
        if (playerBD == null) {
            DAOFactory.getFactory().getPlayerDAO().create(player);
            this.getTicTacToeStatesManager().login(player);
            return true;
        } else {
            return false;
        }
    }

}