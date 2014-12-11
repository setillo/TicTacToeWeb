package es.art83.ticTacToe.controllers.ejbs;

public class ControllerEJB {

    private TicTacToeContext ticTacToeContext;

    public ControllerEJB(TicTacToeContext ticTacToeContext) {
        this.ticTacToeContext = ticTacToeContext;
    }

    protected TicTacToeContext getTicTacToeContext() {
        return ticTacToeContext;
    }

}
