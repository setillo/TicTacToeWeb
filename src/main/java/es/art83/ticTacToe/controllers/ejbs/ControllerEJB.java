package es.art83.ticTacToe.controllers.ejbs;

public class ControllerEJB {

    private TicTacToeApplicationManager ticTacToeStatesManager;

    public ControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        this.ticTacToeStatesManager = ticTacToeStatesManager;
    }

    protected TicTacToeApplicationManager getTicTacToeStatesManager() {
        return ticTacToeStatesManager;
    }

}
