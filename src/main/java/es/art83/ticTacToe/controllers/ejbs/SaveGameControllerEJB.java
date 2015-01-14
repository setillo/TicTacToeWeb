package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;

public class SaveGameControllerEJB extends ControllerEJB implements SaveGameController {

    public SaveGameControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    // JPA actualización de claves foráneas
    private void defineForeignKeys(GameEntity gameEntity) {
        gameEntity.getTurn().setGame(gameEntity);
        gameEntity.getBoard().setGame(gameEntity);
        for (PieceEntity pieceEntity : gameEntity.getBoard().getPieces()) {
            pieceEntity.setBoard(gameEntity.getBoard());
            pieceEntity.getCoordinate().setPiece(pieceEntity);
        }
    }

    @Override
    public void saveGame(String gameName) {
        GameEntity gameEntity = this.getTicTacToeContext().getGame();
        gameEntity.setName(gameName);
        
        this.defineForeignKeys(gameEntity);

        DAOFactory.getFactory().getGameDAO().create(gameEntity);
        this.getTicTacToeContext().setSaved(true);
    }

    @Override
    public void overWriteGame(String gameName) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findGame(this.getTicTacToeContext().getPlayer(), gameName);
        DAOFactory.getFactory().getGameDAO().delete(game);
        this.saveGame(gameName);
    }

    @Override
    public void saveGame() {
        GameEntity gameEntity = this.getTicTacToeContext().getGame();
        this.defineForeignKeys(gameEntity);
        DAOFactory.getFactory().getGameDAO().update(gameEntity);
        this.getTicTacToeContext().setSaved(true);
    }

}
