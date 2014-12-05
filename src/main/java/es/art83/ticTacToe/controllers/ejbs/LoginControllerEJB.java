package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LoginControllerEJB extends ControllerEJB implements LoginController {

    public LoginControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void login(PlayerEntity player) {
        assert this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.INITIAL
                || this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
        this.getTicTacToeStatesManager().setPlayer(player);
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
    }

    @Override
    public boolean read(PlayerEntity player) {
        PlayerEntity playerBD = DAOFactory.getFactory().getPlayerDAO().read(player.getUser());
        if (playerBD != null && playerBD.getPassword().equals(player.getPassword())) {
            this.login(playerBD);
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
            this.login(player);
            return true;
        } else {
            return false;
        }
    }

}
