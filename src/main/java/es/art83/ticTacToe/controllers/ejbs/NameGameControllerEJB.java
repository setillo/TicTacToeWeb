package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.NameGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;

public class NameGameControllerEJB extends ControllerEJB implements NameGameController {


    public NameGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public List<String> gameNames() {
        return DAOFactory.getFactory().getGameDAO().findPlayerGameNames(this.getTicTacToeContext().getPlayer());
    }

}
