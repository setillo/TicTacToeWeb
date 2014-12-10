package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.Controller;

public class ControllerEJB implements Controller{
    
    private TicTacToeApplicationManager ticTacToeStatesManager;

    public ControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
       this.ticTacToeStatesManager = ticTacToeStatesManager;
    }
    
    protected TicTacToeApplicationManager getTicTacToeStatesManager() {
        return ticTacToeStatesManager;
    }

}
