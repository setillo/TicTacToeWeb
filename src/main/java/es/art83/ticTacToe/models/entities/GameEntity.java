package es.art83.ticTacToe.models.entities;

import java.util.List;

import es.art83.ticTacToe.models.utils.ColorModel;

public class GameEntity {
    private int id;

    private String name;

    private PlayerEntity playerEntity;

    private TurnEntity turnEntity;

    private BoardEntity boardEntity;

    public GameEntity(String name, PlayerEntity playerEntity) {
        this.name = name;
        this.playerEntity = playerEntity;
        this.turnEntity = new TurnEntity();
        this.boardEntity = new BoardEntity();
    }

    public GameEntity() {
        this(null, new PlayerEntity());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public TurnEntity getTurnEntity() {
        return turnEntity;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public boolean isGameOver() {
        return this.boardEntity.hayTER();
    }

    public ColorModel[][] completeBoard() {
        return this.boardEntity.completeBoard();
    }

    public ColorModel winner() {
        return this.turnEntity.colorContrario();
    }

    public ColorModel turnColor() {
        return this.turnEntity.getColor();
    }

    public boolean isFullBoard() {
        return this.boardEntity.tableroCompleto();
    }

    public List<CoordinateEntity> validSourceCoordinates() {
        return this.boardEntity.coordenadas(this.turnColor());
    }

    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.boardEntity.coordenadasDestinosValidas();
    }

}
