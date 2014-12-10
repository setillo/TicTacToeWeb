package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class PlaceCardControllerEJB extends ControllerEJB implements PlaceCardController {

    public PlaceCardControllerEJB(TicTacToeApplicationManager ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }
    
    private void changeState(){
        this.getTicTacToeStatesManager().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);        
    }
    
    private void placeCard(){
        assert this.getTicTacToeStatesManager().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        if (this.getTicTacToeStatesManager().getGame().isGameOver()){
            this.changeState();
        }else{
            this.getTicTacToeStatesManager().setSaved(false);
        }
    }

    @Override
    public void placeCard(CoordinateEntity coordinateEntity) {
        this.getTicTacToeStatesManager().getGame().placeCard(coordinateEntity);
        this.placeCard();
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.getTicTacToeStatesManager().getGame().placeCard(source,destination);
        this.placeCard();
    }

}
