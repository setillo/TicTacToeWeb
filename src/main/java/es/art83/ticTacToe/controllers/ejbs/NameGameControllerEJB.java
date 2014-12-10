package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.NameGameController;

public class NameGameControllerEJB extends ControllerEJB implements NameGameController {


    public NameGameControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

}
