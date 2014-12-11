package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.StartGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class StartGameControllerEJB extends ControllerEJB implements StartGameController {

    public StartGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public List<String> readGameNames() {
        PlayerEntity player = this.getTicTacToeContext().getPlayer();
        return DAOFactory.getFactory().getGameDAO().findPlayerGameNames(player);
    }

}
