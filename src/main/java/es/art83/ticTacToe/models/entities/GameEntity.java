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

    public GameEntity(PlayerEntity playerEntity) {
        this(null, playerEntity);
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

    public void setName(String name) {
        this.name = name;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public TurnEntity getTurnEntity() {
        return turnEntity;
    }

    public void setTurnEntity(TurnEntity turnEntity) {
        this.turnEntity = turnEntity;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
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

    public void placeCard(CoordinateEntity coordinateEntity) {
        this.boardEntity.poner(new PieceEntity(this.getTurnEntity().getColor(), coordinateEntity));
        this.turnEntity.cambiar();
    }

    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.boardEntity.quitar(source);
        this.placeCard(destination);
    }

    @Override
    public String toString() {
        return "GameEntity[" + id + ":" + name + "," + playerEntity + "," + turnEntity + ","
                + boardEntity + "]";
    }

}
