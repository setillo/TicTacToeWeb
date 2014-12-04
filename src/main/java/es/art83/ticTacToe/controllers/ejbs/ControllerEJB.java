package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.Controller;

public class ControllerEJB implements Controller{
    
    private TicTacToeStatesManager ticTacToeStatesManager;

    public ControllerEJB(TicTacToeStatesManager ticTacToeStatesManager) {
       this.ticTacToeStatesManager = ticTacToeStatesManager;
    }
    
    protected TicTacToeStatesManager getTicTacToeStatesManager() {
        return ticTacToeStatesManager;
    }

}
